package com.credibanco.assessment.library.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dto.EntityToDto;
import com.credibanco.assessment.library.dto.Libro;
import com.credibanco.assessment.library.model.EditorialEntity;
import com.credibanco.assessment.library.model.LibroEntity;
import com.credibanco.assessment.library.repository.LibroRepository;
import com.credibanco.assessment.library.service.AutorService;
import com.credibanco.assessment.library.service.EditorialService;
import com.credibanco.assessment.library.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository repository;

	@Autowired
	private EntityToDto entityToDto;

	@Autowired
	private EditorialService servicioEditorial;

	@Autowired
	private AutorService servicioAutor;

	@Override
	public Libro registrarLibro(Libro libroDto) {
		Libro libroDTO = null;
		Long editorial_id = libroDto.getEditorial_id();
		Long autor_id = libroDto.getAutor_id();
		EditorialEntity editorial = null;
		try {
			editorial = servicioEditorial.buscarEditorial(editorial_id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("La editorial con id " + editorial_id + " no está registrada");
		}
		try {
			servicioAutor.buscarAutor(autor_id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("El autor con id " + autor_id + " no está registrado");
		}
		try {
			int max_numeros = editorial.getMax_libros();
			if (max_numeros != -1) {
				long n_libros = contarLibros(editorial_id);
				if (max_numeros == (int) n_libros) {
					throw new Exception(
							"No es posible registrar el libro en la editorial, se alcanzó el máximo permitido");
				}
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException(
					"No es posible registrar el libro en la editorial, se alcanzó el máximo permitido");
		}
		LibroEntity libro = new LibroEntity();
		libro.setTitulo(libroDto.getTitulo());
		libro.setAnio(libroDto.getAnio());
		libro.setGenero(libroDto.getGenero());
		libro.setNumero_paginas(libroDto.getNumero_paginas());
		libro.setEditorial_id(libroDto.getEditorial_id());
		libro.setAutor_id(libroDto.getAutor_id());
		repository.save(libro);
		libroDTO = entityToDto.convertToDTOLibro(libro);
		return libroDTO;
	}

	@Override
	public long contarLibros(Long editorial_id) {
		return repository.contarLibros(editorial_id);
	}

	@Override
	public List<Libro> buscarLibros(String titulo, int anio, String genero, int numero_paginas, Long editorial_id,
			Long autor_id) {
		List<Libro> list = null;
		List<LibroEntity> libros = repository.findAll();
		if (!titulo.equals("null")) {
			libros = libros.stream().filter(l -> l.getTitulo().equals(titulo)).collect(Collectors.toList());
		}
		if (anio != 0) {
			libros = libros.stream().filter(l -> l.getAnio() == anio).collect(Collectors.toList());
		}
		if (!genero.equals("null")) {
			libros = libros.stream().filter(l -> l.getGenero().equals(genero)).collect(Collectors.toList());
		}
		if (numero_paginas != 0) {
			libros = libros.stream().filter(l -> l.getNumero_paginas() == numero_paginas).collect(Collectors.toList());
		}
		if (editorial_id != 0) {
			libros = libros.stream().filter(l -> l.getEditorial_id() == editorial_id).collect(Collectors.toList());
		}
		if (autor_id != 0) {
			libros = libros.stream().filter(l -> l.getAutor_id() == autor_id).collect(Collectors.toList());
		}
		list = libros.stream().map(param -> entityToDto.convertToDTOLibro(param)).collect(Collectors.toList());
		return list;
	}
}

package com.credibanco.assessment.library.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.dto.Autor;
import com.credibanco.assessment.library.dto.EntityToDto;
import com.credibanco.assessment.library.model.AutorEntity;
import com.credibanco.assessment.library.repository.AutorRepository;
import com.credibanco.assessment.library.service.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository repository;

	@Autowired
	private EntityToDto entityToDto;

	@Override
	public Autor registrarAutor(Autor autorDto) {
		Autor autorDTO = null;
		AutorEntity autor = new AutorEntity();
		autor.setNombre_completo(autorDto.getNombre_completo());
		autor.setFecha_nacimiento(autorDto.getFecha_nacimiento());
		autor.setCiudad_procedencia(autorDto.getCiudad_procedencia());
		autor.setCorreo(autorDto.getCorreo());

		repository.save(autor);

		autorDTO = entityToDto.convertToDTOAutor(autor);

		return autorDTO;
	}

	@Override
	public AutorEntity buscarAutor(Long autor_id) {
		return repository.findById(autor_id).orElseThrow(() -> new ResourceNotFoundException("Autor no encontrado"));
	}

	@Override
	public List<Autor> listarAutores() {
		List<Autor> list = null;
		List<AutorEntity> autor = repository.findAll();
		list = autor.stream().map(param -> entityToDto.convertToDTOAutor(param)).collect(Collectors.toList());
		return list;
	}

}

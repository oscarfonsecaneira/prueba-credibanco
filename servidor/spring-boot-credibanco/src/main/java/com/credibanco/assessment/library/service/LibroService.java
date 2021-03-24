package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.dto.Libro;

public interface LibroService {

	public Libro registrarLibro(Libro libroDto);

	public long contarLibros(Long editorial_id);

	public List<Libro> buscarLibros(String titulo, int anio, String genero, int numero_paginas, Long editorial_id,
			Long autor_id);

}

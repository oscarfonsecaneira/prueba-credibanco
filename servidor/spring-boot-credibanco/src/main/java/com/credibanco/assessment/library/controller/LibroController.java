package com.credibanco.assessment.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.Libro;
import com.credibanco.assessment.library.service.LibroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/libros")
public class LibroController {

	private static final Logger LOG = LoggerFactory.getLogger(LibroController.class);

	@Autowired
	private LibroService servicio;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/registro")
	public ResponseEntity<Libro> registrarLibro(@Valid @RequestBody Libro libroDto) {
		try {
			Libro respuesta = servicio.registrarLibro(libroDto);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			LOG.warn("Error" + e);
			throw new ResourceNotFoundException("Error: " + e.getMessage());
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/busqueda/{titulo}/{anio}/{genero}/{numero_paginas}/{editorial_id}/{autor_id}")
	public ResponseEntity<List<Libro>> buscarLibros(@PathVariable String titulo, @PathVariable int anio,
			@PathVariable String genero, @PathVariable int numero_paginas, @PathVariable Long editorial_id,
			@PathVariable Long autor_id) {
		try {
			List<Libro> respuesta = servicio.buscarLibros(titulo, anio, genero, numero_paginas, editorial_id, autor_id);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			LOG.warn("Error" + e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

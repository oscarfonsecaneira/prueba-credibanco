package com.credibanco.assessment.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.Autor;
import com.credibanco.assessment.library.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private static final Logger LOG = LoggerFactory.getLogger(AutorController.class);

	@Autowired
	private AutorService servicio;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/registro")
	public ResponseEntity<Autor> registrarAutor(@Valid @RequestBody Autor autorDto) {
		try {
			Autor respuesta = servicio.registrarAutor(autorDto);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			LOG.warn("Error" + e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/listado")
	public ResponseEntity<List<Autor>> listarAutores() {
		try {
			List<Autor> respuesta = servicio.listarAutores();
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			LOG.warn("Error" + e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

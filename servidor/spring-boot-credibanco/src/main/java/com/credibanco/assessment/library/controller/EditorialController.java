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

import com.credibanco.assessment.library.dto.Editorial;
import com.credibanco.assessment.library.service.EditorialService;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {

	private static final Logger LOG = LoggerFactory.getLogger(EditorialController.class);

	@Autowired
	private EditorialService servicio;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/registro")
	public ResponseEntity<Editorial> registrarEditorial(@Valid @RequestBody Editorial editorialDto) {
		try {
			Editorial respuesta = servicio.registrarEditorial(editorialDto);
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			LOG.warn("Error" + e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/listado")
	public ResponseEntity<List<Editorial>> listarEditoriales() {
		try {
			List<Editorial> respuesta = servicio.listarEditoriales();
			return new ResponseEntity<>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			LOG.warn("Error" + e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

package com.credibanco.assessment.library.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(max = 50, message = "El título del libro no puede sobrepasar los 50 caracteres")
	@NotNull(message = "El título del libro es obligatorio")
	private String titulo;
	
	@Max(value = 2021, message = "El año del libro no puede ser mayor al actual 2021")
	private int anio;
	
	@NotNull(message = "El género del libro es obligatorio")
	private String genero;
	
	@Min(value = 1, message = "Debe haber mínimo una página del libro")
	@NotNull(message = "El número de páginas es obligatorio")
	private int numero_paginas;
	
	@Min(value = 1, message = "El ID de la editorial debe ser mayor o igual a 1")
	@NotNull(message = "Se debe indicar el ID de la editorial")
	private Long editorial_id;
	
	@Min(value = 1, message = "El ID del autor debe ser mayor o igual a 1")
	@NotNull(message = "Se debe indicar el ID del autor")
	private Long autor_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getNumero_paginas() {
		return numero_paginas;
	}

	public void setNumero_paginas(int numero_paginas) {
		this.numero_paginas = numero_paginas;
	}

	public Long getEditorial_id() {
		return editorial_id;
	}

	public void setEditorial_id(Long editorial_id) {
		this.editorial_id = editorial_id;
	}

	public Long getAutor_id() {
		return autor_id;
	}

	public void setAutor_id(Long autor_id) {
		this.autor_id = autor_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

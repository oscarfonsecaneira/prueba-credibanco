package com.credibanco.assessment.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRO")
public class LibroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libtid_generator")
	@SequenceGenerator(name = "libtid_generator", sequenceName = "libro_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "ANIO")
	private int anio;

	@Column(name = "GENERO")
	private String genero;

	@Column(name = "NUMERO_PAGINAS")
	private int numero_paginas;

	@Column(name = "EDITORIAL_ID")
	private Long editorial_id;

	@Column(name = "AUTOR_ID")
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

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", anio=" + anio + ", genero=" + genero + ", numero_paginas="
				+ numero_paginas + ", editorial_id=" + editorial_id + ", autor_id=" + autor_id + "]";
	}

}

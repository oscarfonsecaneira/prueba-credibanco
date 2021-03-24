package com.credibanco.assessment.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "EDITORIAL")
public class EditorialEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edtid_generator")
	@SequenceGenerator(name = "edtid_generator", sequenceName = "editorial_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "DIRECCION_CORRESPONDENCIA")
	private String direccion_correspondencia;

	@Column(name = "TELEFONO")
	private Long telefono;

	@Column(name = "CORREO")
	private String correo;

	@Column(name = "MAX_LIBROS")
	private int max_libros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion_correspondencia() {
		return direccion_correspondencia;
	}

	public void setDireccion_correspondencia(String direccion_correspondencia) {
		this.direccion_correspondencia = direccion_correspondencia;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getMax_libros() {
		return max_libros;
	}

	public void setMax_libros(int max_libros) {
		this.max_libros = max_libros;
	}

	@Override
	public String toString() {
		return "Editorial [id=" + id + ", nombre=" + nombre + ", direccion_correspondencia=" + direccion_correspondencia
				+ ", telefono=" + telefono + ", correo=" + correo + ", max_libros=" + max_libros + "]";
	}

}

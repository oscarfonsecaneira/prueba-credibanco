package com.credibanco.assessment.library.dto;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Editorial implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(max = 50, message = "El nombre de la editorial no puede sobrepasar los 50 caracteres")
	@NotNull(message = "El nombre de la editorial es obligatorio")
	private String nombre;
	
	@NotNull(message = "La dirección de correspondencia es obligatoria")
	@Size(min = 7, max = 50, message = "La dirección debe estar entre 7 a 50 caracteres")
	private String direccion_correspondencia;
	
	@Digits(integer = 15, fraction = 0, message = "El número de teléfono no puede sobrepasar los 15 dígitos")
	@NotNull(message = "El teléfono de la editorial es obligatorio")
	private Long telefono;
	
	@Email(message = "El correo de la editorial debe ser válido")
	private String correo;
	
	@Min(value = -1, message = "El número máximo de libros debe ser un número positivo")
	private int max_libros = -1;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

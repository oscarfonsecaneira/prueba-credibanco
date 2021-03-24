package com.credibanco.assessment.library.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class Autor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@Size(max = 50, message = "El nombre del autor no puede sobrepasar los 50 caracteres")
	@NotNull(message = "El nombre del autor es obligatorio")
	private String nombre_completo;
	
	@JsonFormat(pattern = "dd-MM-yyyy", shape = Shape.STRING)
	private String fecha_nacimiento;
	
	@Size(max = 50, message = "El nombre de la ciudad no puede sobrepasar los 50 caracteres")
	private String ciudad_procedencia;
	
	@Email(message = "El correo del autor debe ser válido")
	private String correo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getCiudad_procedencia() {
		return ciudad_procedencia;
	}

	public void setCiudad_procedencia(String ciudad_procedencia) {
		this.ciudad_procedencia = ciudad_procedencia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

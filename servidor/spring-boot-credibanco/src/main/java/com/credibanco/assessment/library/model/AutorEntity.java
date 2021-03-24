package com.credibanco.assessment.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AUTOR")
public class AutorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autid_generator")
	@SequenceGenerator(name = "autid_generator", sequenceName = "autor_seq", allocationSize = 1)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOMBRE_COMPLETO")
	private String nombre_completo;

	@Column(name = "FECHA_NACIMIENTO")
	private String fecha_nacimiento;

	@Column(name = "CIUDAD_PROCEDENCIA")
	private String ciudad_procedencia;

	@Column(name = "CORREO")
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

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre_completo=" + nombre_completo + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", ciudad_procedencia=" + ciudad_procedencia + ", correo=" + correo + "]";
	}

}

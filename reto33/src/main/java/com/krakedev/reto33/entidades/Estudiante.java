package com.krakedev.reto33.entidades;

import java.util.Date;

public class Estudiante{
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaNac;
	private Profesor codigoProf;
	
	public Estudiante() {
		super();
	}
	public Estudiante(String cedula, String nombre, String apellido, String email, Date fechaNac, Profesor codigoProf) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.codigoProf=codigoProf;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}


	public String getCedula() {
		return cedula;
	}


	public Profesor getCodigoProf() {
		return codigoProf;
	}
	public void setCodigoProf(Profesor codigoProf) {
		this.codigoProf = codigoProf;
	}
	@Override
	public String toString() {
		return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", fechaNac=" + fechaNac + ", codigoProf=" + codigoProf + "]";
	}

	
	
	
	
	
}

package com.krakedev.persistencia.entidades;

import java.math.BigDecimal;
import java.util.Date;

public class Persona{
	private Prestamo cedula;
	private String nombre;
	private String apellido;
	private double estatura;
	private Date fechaNac;
	private Date horaNac;
	private BigDecimal cantidadAhorrada;
	private int numeroHijos;
	public Persona() {
		super();
	}
	public Persona(Prestamo cedula, String nombre, String apellido, Date fechaNac) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
	}
	public Prestamo getCedula() {
		return cedula;
	}
	public void setCedula(Prestamo cedula) {
		this.cedula = cedula;
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
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Date getHoraNac() {
		return horaNac;
	}
	public void setHoraNac(Date horaNac) {
		this.horaNac = horaNac;
	}
	public BigDecimal getCantidadAhorrada() {
		return cantidadAhorrada;
	}
	public void setCantidadAhorrada(BigDecimal cantidadAhorrada) {
		this.cantidadAhorrada = cantidadAhorrada;
	}
	public int getNumeroHijos() {
		return numeroHijos;
	}
	public void setNumeroHijos(int numeroHijos) {
		this.numeroHijos = numeroHijos;
	}
	
	
	
	
}

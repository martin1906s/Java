package com.krakedev;

public class Mensajeria {
	private String nombre;
	private String apellido;
	
	public Mensajeria(String nombre) {
		this.nombre=nombre;
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

	public void getSaludar() {
		System.out.println("Hola Mundo");
	}
}

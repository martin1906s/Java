package com.cmc.repaso.entidades;

public class Estudiante {
	private String nombre;
	private double nota;
	private String resultado;
	

	public String getNombre() {
		return nombre;
	}

	public String getResultado() {
		return resultado;
	}

	public Estudiante(String nombre) {
		this.nombre=nombre;
	}
	
	public void calificar(double nota) {
		this.nota=nota;
		if(this.nota>=0 && this.nota<8) {
			this.resultado="F";
		}else if(this.nota>=8 && this.nota<=10) {
			this.resultado="A";
		}else {
			this.resultado="Error en nota";
		}
	}

}

package com.krakedev;

public class Calculadora {
	private int suma;
	private int resta;
	private double multiplicar;
	private double dividir;
	private double promediar;
	
	
	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma1, int suma2) {
		this.suma = suma1 + suma2;
	}

	public int getResta() {
		return resta;
	}

	public void setResta(int resta1, int resta2) {
		this.resta = resta1 - resta2;
	}

	public double getMultiplicar() {
		return multiplicar;
	}

	public void setMultiplicar(double multiplicar1, double multiplicar2) {
		this.multiplicar = multiplicar1 * multiplicar2;
	}

	public double getDividir() {
		return dividir;
	}

	public void setDividir(double dividendo, double divisor) {
		this.dividir = dividendo / divisor;
	}

	public double getPromediar() {
		return promediar;
	}

	public void setPromediar(double valor1, double valor2, double valor3) {
		this.promediar = (valor1 + valor2 + valor3)/3;
	}

	public void getMostrarResultado() {
		System.out.println("Ahora no joven, Salí al almuerzo. Regreso en 15min.");
	}
}

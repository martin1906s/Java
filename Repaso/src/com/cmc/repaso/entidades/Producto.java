package com.cmc.repaso.entidades;

public class Producto {
	private String nombre;
	private double precio;
	
	public Producto(String nombre, double precio) {
		this.nombre=nombre;
		this.precio=precio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
		if (this.precio<0) {
			this.precio*=-1;
		}
	}

	public String getNombre() {
		return nombre;
	}
	
	public double calcularPrecioPromo(double porcentajeDescuento) {
		double descuento=(porcentajeDescuento/100)*this.precio;
		return this.precio-descuento;
	}
	
}

package com.cmc.repaso.entidades;

public class Item {
	private String nombre;
	private int productosActuales;
	private int productosDevueltos;
	private int productosVendidos;

	public Item(String nombre, int productosActuales) {
		this.nombre = nombre;
		this.productosActuales = productosActuales;
		this.productosDevueltos = 0;
		this.productosVendidos = 0;
	}

	public void imprimir() {
		System.out.println("*******************");
		System.out.println("Nombre: " + nombre);
		System.out.println("Productos Actuales: " + this.productosActuales);
		System.out.println("Productos Devueltos: " + this.productosDevueltos);
		System.out.println("Productos Vendidos: " + this.productosVendidos);
		System.out.println("*******************");
	}

	public void vender(int productosVendidos) {
		if (productosVendidos <= this.productosActuales) {
			this.productosActuales -= productosVendidos;
			this.productosVendidos += productosVendidos;
		} else {
			System.out.println("No hay más " + this.nombre + " para vender");
		}
	}

	public void devolver(int productosDevueltos) {
		this.productosActuales += productosDevueltos;
		this.productosVendidos -= productosDevueltos;
		this.productosDevueltos += productosDevueltos;
	}

	public int getProductosActuales() {
		return productosActuales;
	}

	public int getProductosVendidos() {
		return productosVendidos;
	}

	public int getProductosDevueltos() {
		return productosDevueltos;
	}
}

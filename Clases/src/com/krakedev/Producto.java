package com.krakedev;

public class Producto {
	private String nombre;
	private String descripcion;
	private double precio;
	private int stockActual;
	
	public Producto(String nombre) {
		this.nombre=nombre;
	}
	public Producto(String nombre, int stock) {
		this.nombre=nombre;
		this.stockActual=stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStockActual() {
		return stockActual;
	}
	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}
	
	
}

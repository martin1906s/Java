package com.clearminds.test;

import com.clearminds.componentes.Producto;

public class TestProducto {
	public static void main(String[] args) {
		Producto producto = new Producto("KE34", "Papitas", 0.85);
		System.out.println("Codigo:" + producto.getCodigo());
		System.out.println("Nombre:" + producto.getNombre());
		System.out.println("Precio:" + producto.getPrecio());
		System.out.println("*************************************");
		producto.setPrecio(0.90);
		System.out.println("Nuevo Precio:" + producto.getPrecio());

		producto.incrementarPrecio(50);
		System.out.println("Precio incrementado:" + producto.getPrecio());

		producto.disminuirPrecio(0.35);
		;
		System.out.println("Precio incrementado:" + producto.getPrecio());

	}
}

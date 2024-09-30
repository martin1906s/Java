package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto p1=new Producto("Leche",15.75);
		Producto p2=new Producto("Arroz",10.25);
		Producto p3=new Producto("Huevos",15.5);
		System.out.println("____________________________");
		System.out.println("Nombre: " + p1.getNombre());
        System.out.println("Precio sin descuento: " + p1.getPrecio());
        double precioConDescuento1 = p1.calcularPrecioPromo(20);
        System.out.println("Precio con descuento del 20%: " + precioConDescuento1);
		System.out.println("____________________________");
		System.out.println("Nombre: " + p2.getNombre());
        System.out.println("Precio sin descuento: " + p2.getPrecio());
        double precioConDescuento2 = p2.calcularPrecioPromo(10);
        System.out.println("Precio con descuento del 20%: " + precioConDescuento2);
		System.out.println("____________________________");
		System.out.println("Nombre: " + p3.getNombre());
        System.out.println("Precio sin descuento: " + p3.getPrecio());
        double precioConDescuento3 = p3.calcularPrecioPromo(20);
        System.out.println("Precio con descuento del 20%: " + precioConDescuento3);
		System.out.println("____________________________");


		
	}

}

package com.krakedev;

public class TestProduto {

	public static void main(String[] args) {
		Producto productoA=new Producto();
		Producto productoB=new Producto();
		Producto productoC=new Producto();
		
		productoA.nombre="Paracetamol";
		productoA.precio=1.25;
		productoA.stockActual=50;
		productoA.descripcion="Pastilla";
		
		productoB.nombre="Ibuprofeno";
		productoB.precio=1.50;
		productoB.stockActual=12;
		productoB.descripcion="Pastilla";
		
		productoC.nombre="Curita";
		productoC.precio=0.50;
		productoC.stockActual=2;
		productoC.descripcion="Bandita";
		
		System.out.println("--------------------");
		System.out.println("Nombre: "+productoA.nombre);
		System.out.println("Precio: "+productoA.precio);
		System.out.println("Stock: "+productoA.stockActual);
		System.out.println("Descripcion: "+productoA.descripcion);
		System.out.println("--------------------");
		System.out.println("Nombre: "+productoB.nombre);
		System.out.println("Precio: "+productoB.precio);
		System.out.println("Stock: "+productoB.stockActual);
		System.out.println("Descripcion: "+productoB.descripcion);
		System.out.println("--------------------");
		System.out.println("Nombre: "+productoC.nombre);
		System.out.println("Precio: "+productoC.precio);
		System.out.println("Stock: "+productoC.stockActual);
		System.out.println("Descripcion: "+productoC.descripcion);
	}

}

package com.krakedev;

public class TestProduto {
	
	public static void main(String[] args) {
		Producto productoA=new Producto();
		Producto productoB=new Producto();
		Producto productoC=new Producto();
		
		productoA.setNombre("Paracetamol");
		productoA.setPrecio(1.25);
		productoA.setStockActual(50);;
		productoA.setDescripcion("Pastilla");
		
		productoB.setNombre("Ibuprofeno");
		productoB.setPrecio(1.50);
		productoB.setStockActual(12);
		productoB.setDescripcion("Pastilla");
		
		productoC.setNombre("Curita");
		productoC.setPrecio(0.50);
		productoC.setStockActual(2);
		productoC.setDescripcion("Bandita");
		
		System.out.println("--------------------");
		System.out.println("Nombre: "+productoA.getNombre());
		System.out.println("Precio: "+productoA.getPrecio());
		System.out.println("Stock: "+productoA.getStockActual());
		System.out.println("Descripcion: "+productoA.getDescripcion());
		System.out.println("--------------------");
		System.out.println("Nombre: "+productoB.getNombre());
		System.out.println("Precio: "+productoB.getPrecio());
		System.out.println("Stock: "+productoB.getStockActual());
		System.out.println("Descripcion: "+productoB.getDescripcion());
		System.out.println("--------------------");
		System.out.println("Nombre: "+productoC.getNombre());
		System.out.println("Precio: "+productoC.getPrecio());
		System.out.println("Stock: "+productoC.getStockActual());
		System.out.println("Descripcion: "+productoC.getDescripcion());
	}

}

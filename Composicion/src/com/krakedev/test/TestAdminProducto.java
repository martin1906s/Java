package com.krakedev.test;

import com.krakedev.composicion.AdminProducto;
import com.krakedev.composicion.Producto;

public class TestAdminProducto {

	public static void main(String[] args) {
		Producto mc;
		AdminProducto admin = new AdminProducto();
		Producto productoA = new Producto("Doritos", 0.50);
		Producto productoB = new Producto("Papitas", 0.50);
		mc = admin.buscarMasCaro(productoA, productoB);
		if (mc == null) {
			System.out.println("Son Iguales");
		} else {
			System.out.println("El mas caro es: " + mc.getNombre());
		}

	}

}

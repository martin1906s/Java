package com.krakedev.composicion;

public class AdminProducto {
	public Producto buscarMasCaro(Producto p1, Producto p2) {
		if(p1.getPrecio()>p2.getPrecio()) {
			return p1;
		}else if(p2.getPrecio()>p1.getPrecio()) {
			return p2;
		}else {
			return null;
		}
	}
}

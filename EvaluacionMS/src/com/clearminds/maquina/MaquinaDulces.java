package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;

	public Celda getCelda1() {
		return celda1;
	}

	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}

	public Celda getCelda2() {
		return celda2;
	}

	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}

	public Celda getCelda3() {
		return celda3;
	}

	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}

	public Celda getCelda4() {
		return celda4;
	}

	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void configurarMaquina(String c1, String c2, String c3, String c4) {
		this.celda1 = new Celda(c1);
		this.celda2 = new Celda(c2);
		this.celda3 = new Celda(c3);
		this.celda4 = new Celda(c4);
	}

	public void mostrarConfiguracion() {
		System.out.println("Celda 1: " + celda1.getCodigo());
		System.out.println("Celda 2: " + celda2.getCodigo());
		System.out.println("Celda 3: " + celda3.getCodigo());
		System.out.println("Celda 4: " + celda4.getCodigo());

	}

	public Celda buscarCelda(String codigo) {
		if (codigo == celda1.getCodigo()) {
			return celda1;
		} else if (codigo == celda2.getCodigo()) {
			return celda2;
		} else if (codigo == celda3.getCodigo()) {
			return celda3;
		} else if (codigo == celda4.getCodigo()) {
			return celda4;
		} else {
			return null;
		}
	}

	public void cargarProducto(Producto prod, String cod, int items) {
		Celda celdaRecuperada = buscarCelda(cod);
		celdaRecuperada.ingresarProducto(prod, items);	
		
	}

	public void mostrarProductos() {
		System.out.println("************CELDA " + celda1.getCodigo());
	    System.out.println("  Stock:" + celda1.getStock());
	    if (celda1.getProducto() != null) {
	        System.out.println("  Nombre Producto:" + celda1.getProducto().getNombre());
	        System.out.println("  Precio Producto:" + celda1.getProducto().getPrecio());
	        System.out.println("  Código Producto:" + celda1.getProducto().getCodigo());
	    } else {
	        System.out.println("  La celda no tiene producto!!!");
	    }

	    System.out.println("************CELDA " + celda2.getCodigo());
	    System.out.println("  Stock:" + celda2.getStock());
	    if (celda2.getProducto() != null) {
	        System.out.println("  Nombre Producto:" + celda2.getProducto().getNombre());
	        System.out.println("  Precio Producto:" + celda2.getProducto().getPrecio());
	        System.out.println("  Código Producto:" + celda2.getProducto().getCodigo());
	    } else {
	        System.out.println("  La celda no tiene producto!!!");
	    }

	    System.out.println("************CELDA " + celda3.getCodigo());
	    System.out.println("  Stock:" + celda3.getStock());
	    if (celda3.getProducto() != null) {
	        System.out.println("  Nombre Producto:" + celda3.getProducto().getNombre());
	        System.out.println("  Precio Producto:" + celda3.getProducto().getPrecio());
	        System.out.println("  Código Producto:" + celda3.getProducto().getCodigo());
	    } else {
	        System.out.println("  La celda no tiene producto!!!");
	    }

	    System.out.println("************CELDA " + celda4.getCodigo());
	    System.out.println("  Stock:" + celda4.getStock());
	    if (celda4.getProducto() != null) {
	        System.out.println("  Nombre Producto:" + celda4.getProducto().getNombre());
	        System.out.println("  Precio Producto:" + celda4.getProducto().getPrecio());
	        System.out.println("  Código Producto:" + celda4.getProducto().getCodigo());
	    } else {
	        System.out.println("  La celda no tiene producto!!!");
	    }

	    System.out.println("Saldo: " + saldo);
	}

	public Producto buscarProductoEnCelda(String cod) {
		Celda celda = buscarCelda(cod);
		if (celda != null) {
			return celda.getProducto();
		} else {
			return null;
		}
	}

	public double consultarPrecio(String codC) {
		Celda celdaRecuperada = buscarCelda(codC);
		return celdaRecuperada.getProducto().getPrecio();
	}

	public Celda buscarCeldaProducto(String codP) {
		if (celda1.getProducto() != null && celda1.getCodigo() == codP) {
			return celda1;
		} else if (celda2.getProducto() != null && celda2.getCodigo() == codP) {
			return celda2;
		} else if (celda3.getProducto() != null && celda3.getCodigo() == codP) {
			return celda3;
		} else if (celda4.getProducto() != null && celda4.getCodigo() == codP) {
			return celda4;
		} else {
			return null;
		}
	}

	public void incrementarProductos(String codP, int items) {
		Celda celdaEncontrada = buscarCeldaProducto(codP);
		celdaEncontrada.setStock(celdaEncontrada.getStock() + items);

	}

	public void vender(String codC) {
		Celda celdaEncontrada = buscarCeldaProducto(codC);
		celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);
		double precioProducto = celdaEncontrada.getProducto().getPrecio();
		saldo += precioProducto;
		mostrarProductos();

	}

	public double venderConCambio(String codC, double valorIngresado) {
		Celda celdaEncontrada = buscarCelda(codC);

		if (celdaEncontrada != null && celdaEncontrada.getStock() > 0) {
			double precioProducto = celdaEncontrada.getProducto().getPrecio();

			if (valorIngresado >= precioProducto) {
				celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);

				saldo += precioProducto;

				double cambio = valorIngresado - precioProducto;

				System.out.println("Producto vendido en la celda " + codC + ". Precio: $" + precioProducto
						+ ". Cambio devuelto: $" + cambio);

				return cambio;
			} else {
				System.out.println("Fondos insuficientes. Precio del producto: $" + precioProducto
						+ ". Valor ingresado: $" + valorIngresado);
				return valorIngresado; 
			}
		} else {
			System.out.println("No hay stock en la celda " + codC + " o la celda no fue encontrada.");
			return valorIngresado; 
		}

	}

}

package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double saldo;
	
	public MaquinaDulces() {
        this.celdas = new ArrayList<Celda>();
        this.saldo = 0.0;
    }
	
	public ArrayList<Celda> getCeldas() {
		return celdas;
	}
	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void agregarCelda(Celda codC){
		this.celdas.add(codC);		
	}
	
	public void mostrarConfiguracion() {
		System.out.println("**************");
		for(int i=0;i<celdas.size();i++) {
			System.out.println("Celda"+(i+1)+": "+celdas.get(i).getCodigo());
		}
	}
	
	public Celda buscarCelda(String codigo) {
		for(int i=0;i<celdas.size();i++) {
			Celda celdaEncontrada=celdas.get(i);
			if(celdaEncontrada.getCodigo().equals(codigo)) {
				return celdaEncontrada;
			}
		}
		return null;
	}
	
	public void cargarProducto(Producto prod, String cod, int items) {
		Celda celdaRecuperada = buscarCelda(cod);
		celdaRecuperada.ingresarProducto(prod, items);	
		
	}
	
	public void mostrarProductos() {
	    for (int i = 0; i < celdas.size(); i++) {
	        Celda celda = celdas.get(i);
	        System.out.print("Celda:" + celda.getCodigo() + " Stock:" + celda.getStock());
	        if (celda.getProducto() != null) {
	            System.out.print(" Producto:" + celda.getProducto().getNombre());
	            System.out.println(" Precio:" + celda.getProducto().getPrecio());
	        } else {
	            System.out.println(" Sin Producto asignado");
	        }
	    }
	    System.out.println("Saldo: " + saldo);
	}
	
	public Producto buscarProductoEnCelda(String codC) {
		for(int i=0;i<celdas.size();i++) {
			Celda celdaBuscada=celdas.get(i);
			if(celdaBuscada.getCodigo().equals(codC)) {
				return celdaBuscada.getProducto();
			}
		}
		return null;
	}
	
	public double consultarPrecio(String codC) {
		Celda celdaRecuperada = buscarCelda(codC);
		return celdaRecuperada.getProducto().getPrecio();
	}
	
	public Celda buscarCeldaProducto(String codP) {
	    for (int i = 0; i < celdas.size(); i++) {
	        Celda celda = celdas.get(i);
	        if (celda.getProducto() != null && celda.getProducto().getCodigo().equals(codP)) {
	            return celda;
	        }
	    }
	    return null;
	}
	
	public void incrementarProductos(String codP, int items) {
		Celda celdaEncontrada = buscarCeldaProducto(codP);
		celdaEncontrada.setStock(celdaEncontrada.getStock() + items);

	}
	
	
	
	public void vender(String codC) {
	    Celda celdaEncontrada = buscarCelda(codC);
	    
	    if (celdaEncontrada != null) {
	        if (celdaEncontrada.getStock() > 0) {
	            double precioProducto = celdaEncontrada.getProducto().getPrecio();
	            celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);
	            saldo += precioProducto;
	        } else {
	        }
	    } else {
	    }
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
	
	public void buscarMenores(double precioUmbral) {
	    ArrayList<Producto> productosMenores = new ArrayList<>();
	    for (int i = 0; i < celdas.size(); i++) {
	        Celda celda = celdas.get(i);
	        if (celda.getProducto() != null && celda.getProducto().getPrecio() < precioUmbral) {
	            productosMenores.add(celda.getProducto());
	        }
	    }
	    System.out.println("Productos menores a " + precioUmbral + ":");
	    for (int i = 0; i < productosMenores.size(); i++) {
	        Producto producto = productosMenores.get(i);
	        System.out.println("Nombre: " + producto.getNombre() + " Precio: " + producto.getPrecio());
	    }
	}




	
}

package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class DetallePedido {
	private int codigo;
	private Pedido cabecera;
	private Producto producto;
	private int cantidad;
	private BigDecimal subtotal;
	private int cantidadRecibida;
	public DetallePedido() {}
	public DetallePedido(int codigo, Pedido cabecera, Producto producto, int cantidad, BigDecimal subtotal,
			int cantidadRecibida) {
		super();
		this.codigo = codigo;
		this.cabecera = cabecera;
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
		this.cantidadRecibida = cantidadRecibida;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Pedido getCabecera() {
		return cabecera;
	}
	public void setCabecera(Pedido cabecera) {
		this.cabecera = cabecera;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public int getCantidadRecibida() {
		return cantidadRecibida;
	}
	public void setCantidadRecibida(int cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}
	@Override
	public String toString() {
		return "DetallePedido [codigo=" + codigo + ", cabecera=" + cabecera + ", producto=" + producto + ", cantidad="
				+ cantidad + ", subtotal=" + subtotal + ", cantidadRecibida=" + cantidadRecibida + "]";
	}
	
	
}

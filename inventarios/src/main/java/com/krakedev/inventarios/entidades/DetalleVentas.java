package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class DetalleVentas {
	private int codigo;
	private CabeceraVentas cabecera_ventas;
	private Producto producto;
	private int cantidad;
	private BigDecimal precioVenta;
	private BigDecimal subtotal;
	private BigDecimal subtotalConIVA;
	public DetalleVentas() {}
	public DetalleVentas(int codigo, CabeceraVentas cabecera_ventas, Producto producto, int cantidad,
			BigDecimal precioVenta, BigDecimal subtotal, BigDecimal subtotalConIVA) {
		super();
		this.codigo = codigo;
		this.cabecera_ventas = cabecera_ventas;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioVenta = precioVenta;
		this.subtotal = subtotal;
		this.subtotalConIVA = subtotalConIVA;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public CabeceraVentas getCabecera_ventas() {
		return cabecera_ventas;
	}
	public void setCabecera_ventas(CabeceraVentas cabecera_ventas) {
		this.cabecera_ventas = cabecera_ventas;
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
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public BigDecimal getSubtotalConIVA() {
		return subtotalConIVA;
	}
	public void setSubtotalConIVA(BigDecimal subtotalConIVA) {
		this.subtotalConIVA = subtotalConIVA;
	}
	@Override
	public String toString() {
		return "DetalleVentas [codigo=" + codigo + ", cabecera_ventas=" + cabecera_ventas + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", subtotal=" + subtotal
				+ ", subtotalConIVA=" + subtotalConIVA + "]";
	}
	
}

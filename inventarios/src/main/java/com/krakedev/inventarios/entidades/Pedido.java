package com.krakedev.inventarios.entidades;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	private int numeroPedido;
	private Proveedor proveedor;
	private Date fecha;
	private EstadoPedido estado;
	private ArrayList<DetallePedido> detalles;
	public Pedido() {}
	public Pedido(int numeroPedido, Proveedor proveedor, Date fecha, EstadoPedido estado) {
		super();
		this.numeroPedido = numeroPedido;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.estado = estado;
	}
	public int getNumeroPedido() {
		return numeroPedido;
	}
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EstadoPedido getEstado() {
		return estado;
	}
	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	
	public ArrayList<DetallePedido> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<DetallePedido> detalles) {
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "Pedido [numeroPedido=" + numeroPedido + ", proveedor=" + proveedor + ", fecha=" + fecha + ", estado="
				+ estado + "]";
	}
	
	
}

package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class CabeceraVentas {
	private int codigo;
	private Date fecha;
	private BigDecimal totalSinIVA;
	private int iva;
	private BigDecimal total;
	private ArrayList<DetalleVentas> detalles;
	public CabeceraVentas() {}
	public CabeceraVentas(int codigo, Date fecha, BigDecimal totalSinIVA, int iva, BigDecimal total) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.totalSinIVA = totalSinIVA;
		this.iva = iva;
		this.total = total;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getTotalSinIVA() {
		return totalSinIVA;
	}
	public void setTotalSinIVA(BigDecimal totalSinIVA) {
		this.totalSinIVA = totalSinIVA;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public ArrayList<DetalleVentas> getDetalles() {
		return detalles;
	}
	public void setDetalles(ArrayList<DetalleVentas> detalles) {
		this.detalles = detalles;
	}
	@Override
	public String toString() {
		return "CabeceraVentas [codigo=" + codigo + ", fecha=" + fecha + ", totalSinIVA=" + totalSinIVA + ", iva=" + iva
				+ ", total=" + total + ", detalles=" + detalles + "]";
	}
	
	
}

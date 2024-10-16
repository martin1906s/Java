package com.krakedev.persistencia.entidades;

import java.math.BigDecimal;
import java.util.Date;

public class Prestamo {
	private String cedula;
	private BigDecimal numeroCuenta;
	private Date fechaPrestamo;
	private Date horaPrestamo;
	private String garante;
	public Prestamo() {}
	public Prestamo(String cedula, String garante) {
		super();
		this.cedula = cedula;
		this.garante = garante;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public BigDecimal getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(BigDecimal numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}
	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}
	public Date getHoraPrestamo() {
		return horaPrestamo;
	}
	public void setHoraPrestamo(Date horaPrestamo) {
		this.horaPrestamo = horaPrestamo;
	}
	public String getGarante() {
		return garante;
	}
	public void setGarante(String garante) {
		this.garante = garante;
	}
	@Override
	public String toString() {
		return "Prestamo [cedula=" + cedula + ", numeroCuenta=" + numeroCuenta + ", fechaPrestamo=" + fechaPrestamo
				+ ", horaPrestamo=" + horaPrestamo + ", garante=" + garante + "]";
	}
	
	
	
	
}

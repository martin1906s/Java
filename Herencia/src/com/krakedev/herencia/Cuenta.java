package com.krakedev.herencia;

public class Cuenta {
	private String numeroCuenta;
	private double saldo;
	public Cuenta(String numeroCuenta, double saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Cuenta [numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + "]";
	}
	
	
}

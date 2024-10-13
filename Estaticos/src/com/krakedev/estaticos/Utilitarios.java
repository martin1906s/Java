package com.krakedev.estaticos;

public class Utilitarios {
	public static boolean ValidarRango(int valor) {
		if(valor>=0 && valor<=10) {
			return true;
		}else {
			return false;
		}
	}
}

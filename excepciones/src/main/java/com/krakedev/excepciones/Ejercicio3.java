package com.krakedev.excepciones;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ejercicio3 {
	private static final Logger LOGGER=LogManager.getLogger(Ejercicio3.class);
	public void metodo1() {
		String a = null;
		try {
			a.substring(0);
		}catch(Exception e) {
			System.out.println("Error");
			LOGGER.error("Errror al obtener la subcadena",e);
		}	
	}
	public static void main(String[] args) {
		Ejercicio3 ej=new Ejercicio3();
		ej.metodo1();
	}
}

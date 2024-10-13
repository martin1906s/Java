package com.krakedev.estaticos.ejercicio.utils;

public class Util {
	public static String formatearHora(int hora) {
		if(hora<10){
			return "0"+hora;
		}else {
			return hora+"";
		}
		
	}
	
	public static String formatearDia(int dia) {
		if(DiasSemana.LUNES==dia) {
			return "Lunes";
		}else if(DiasSemana.MARTES==dia) {
			return "Martes";
		}else if(DiasSemana.MIERCOLES==dia) {
			return "Miercoles";
		}else if(DiasSemana.JUEVES==dia) {
			return "Jueves";
		}else if(DiasSemana.VIERNES==dia) {
			return "Viernes";
		}else if(DiasSemana.SABADO==dia) {
			return "Sabado";
		}else {
			return "Domingo";
		}
		
	}
}

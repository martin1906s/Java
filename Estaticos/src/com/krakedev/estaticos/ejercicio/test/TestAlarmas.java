package com.krakedev.estaticos.ejercicio.test;

import java.util.ArrayList;

import com.krakedev.estaticos.DiasSemana;
import com.krakedev.estaticos.ejercicio.entidades.Alarma;
import com.krakedev.estaticos.ejercicio.logica.AdminAlarmas;

public class TestAlarmas {

	public static void main(String[] args) {
		Alarma a1=new Alarma(DiasSemana.LUNES,13,25);
		Alarma a2=new Alarma(DiasSemana.MIERCOLES,1,5);
		Alarma a3=new Alarma(DiasSemana.JUEVES,5,17);
		Alarma a4=new Alarma(DiasSemana.MARTES,20,23);
		Alarma a5=new Alarma(DiasSemana.DOMINGO,19,55);
		AdminAlarmas ad=new AdminAlarmas();
		ad.agregarAlarma(a1);
		ad.agregarAlarma(a2);
		ad.agregarAlarma(a3);
		ad.agregarAlarma(a4);
		ad.agregarAlarma(a5);
		ArrayList<Alarma> alarmasActuales=ad.getAlarmas();
		System.out.println(alarmasActuales);

	}

}

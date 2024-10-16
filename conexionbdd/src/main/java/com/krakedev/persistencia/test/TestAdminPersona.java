package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.entidades.Prestamo;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestAdminPersona {

	public static void main(String[] args) throws Exception {
		Prestamo pres=new Prestamo("1751013192", "Abigail Herrera"); 
		Persona p=new Persona(pres, "Abigail", "Herrera", Convertidor.convertirFecha("1945/06/19"));

		try {
			Date horaNac=Convertidor.convertirHora("12:35");
			p.setCantidadAhorrada(new BigDecimal(500));
			p.setEstatura(1.75);
			p.setHoraNac(horaNac);
			AdminPersonas.insertar(p);

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}


	}

}

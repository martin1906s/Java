package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono3 {

	public static void main(String[] args) {
		Telefono t1=new Telefono("Movi","0987654321", 001);
		Telefono t2=new Telefono("Claro","0978563412",002);
		Telefono t3=new Telefono("Movi","0997654356",003);
		AdminTelefono admin=new AdminTelefono();
		int opMovi=admin.contarMovi(t1, t2, t3);
		System.out.println("Hay "+opMovi+" telefonos con operadora Movistar");
	}

}

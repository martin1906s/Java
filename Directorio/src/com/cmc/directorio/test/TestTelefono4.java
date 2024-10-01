package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono4 {

	public static void main(String[] args) {
		Telefono t1=new Telefono("Claro","0987654321", 001);
		Telefono t2=new Telefono("Claro","0978563412",002);
		Telefono t3=new Telefono("Movi","0997654356",003);
		Telefono t4=new Telefono("Claro","0978773412",004);
		AdminTelefono admin=new AdminTelefono();
		int opClaro=admin.contarClaro(t1, t2, t3, t4);
		System.out.println("Hay "+opClaro+" telefonos con operadora Claro");
	}

}

package com.krakedev.colecciones;

import java.util.ArrayList;

public class TestAdminPersonas {

	public static void main(String[] args) {
		AdminPersonas admin=new AdminPersonas();
		admin.agregar(new Persona("Mario", "Benedetti", 50));
		admin.agregar(new Persona("María", "Mercedes", 74));
		admin.agregar(new Persona("Marco", "Muñoz", 43));
		admin.agregar(new Persona("Alexandra", "Flores", 42));

		admin.imprimir();
		Persona p1=admin.buscarPorNombre("María");
		if(p1!=null) {
			System.out.println("Persona Encotrada: "+p1.getNombre()+" "+p1.getApellido()+ ", "+p1.getEdad()+" años");
		}else {
			System.out.println("Persona NO Encontrada");
		}
		
		ArrayList<Persona> personasMayores=admin.buscarMayor(5);
	}

}

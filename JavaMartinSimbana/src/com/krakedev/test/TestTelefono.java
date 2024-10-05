package com.krakedev.test;
import com.krakedev.evaluacion.Telefono;
import java.util.ArrayList;



public class TestTelefono {
	public static void main(String[] args) {
		 ArrayList<Telefono> teléfonos = new ArrayList();

	        // Teléfonos con estado "C" (correctos)
	        teléfonos.add(new Telefono("1234567890", "Movil"));
	        teléfonos.add(new Telefono("9876543210", "Movil"));
	        teléfonos.add(new Telefono("9876543", "Convencional"));

	        // Teléfonos con estado "E" (incorrectos)
	        teléfonos.add(new Telefono("12345", "Fijo"));
	        teléfonos.add(new Telefono(null, "Movil"));
	        teléfonos.add(new Telefono("12345678", "Incorrecto"));
	        teléfonos.add(new Telefono("1234567890", null));

	        // Mostrar información de todos los teléfonos
	        for (Telefono teléfono : teléfonos) {
	            System.out.println("Número: " + teléfono.getNumero());
	            System.out.println("Tipo: " + teléfono.getTipo());
	            System.out.println("Estado: " + teléfono.getEstado());
	            System.out.println();
	        }
	}
 
}

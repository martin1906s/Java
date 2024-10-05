package krakedev.test;

import krakedev.entidades.Curso;
import krakedev.entidades.Estudiante;
import krakedev.entidades.Materia;
import krakedev.entidades.Nota;

public class TestEstudiante {

	public static void main(String[] args) {
		Estudiante estudiante = new Estudiante("1234567890", "Juan2", "Perez");
		Estudiante estudiante2 = new Estudiante("1234567890", "Juan", "Perez");
		Materia ciencias = new Materia("3", "Ciencias");
		Materia matematicas = new Materia("2", "Matematicas");

		Nota nuevaNota = new Nota(ciencias, 9.0);
		Nota nuevaNota2 = new Nota(ciencias, 9.0);
		Nota nuevaNota3 = new Nota(matematicas, 2.0);
		Nota nuevaNota4 = new Nota(matematicas, -8.0);

		estudiante.agregarNota(nuevaNota);
		// No deberia dejar ingresar esta nota ya que la calificacion esta duplicada.
		estudiante.agregarNota(nuevaNota2);
		// No deberia dejar ingresar esta nota ya que la calificacion es menor a 0.
		estudiante.agregarNota(nuevaNota3);
		estudiante.agregarNota(nuevaNota4);

		estudiante.modificarNota("3", 10.00);
		// No deberia dejar modificar esta nota ya que la calificacion es menor a 0.
		estudiante.modificarNota("3", -1);
		System.out.println(estudiante.calcularPromedioNotasEstudiante());

		estudiante.mostrar();
	}

}

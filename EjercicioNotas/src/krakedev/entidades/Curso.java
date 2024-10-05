package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
	private ArrayList<Estudiante> estudiantes;

	public Curso() {
		this.estudiantes = new ArrayList<>();
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public String buscarEstudiantePorCedula(Estudiante estudiante) {
		for (int i = 0; i < estudiantes.size(); i++) {
			if (estudiante.getCedula().equals(estudiantes.get(i).getCedula())) {
				return "El estudiante si está en el curso";
			}
		}
		return null;
	}

	public void matricularEstudiante(Estudiante estudiante) {
		String estudianteBuscado = buscarEstudiantePorCedula(estudiante);
		if (estudianteBuscado == null) {
			estudiantes.add(estudiante);
			System.out.println("Estudiante Matriculado");
		} else {
			System.out.println("El estudiante ya está matriculado");
		}
	}

	public double calcularPromedioCurso() {
		double suma = 0.0;
		int totalNotas = 0;
		double promedioCurso = 0.0;
		for (int i = 0; i < estudiantes.size(); i++) {
			ArrayList<Nota> notasEstudiante = estudiantes.get(i).getNotas();
			for (int j = 0; j < notasEstudiante.size(); j++) {
				suma += notasEstudiante.get(j).getCalificacion();
				totalNotas++;
			}

		}
		if (totalNotas > 0) {
			promedioCurso = suma / totalNotas;
		} else {
			promedioCurso = -1;
		}
		return promedioCurso;
	}

	public void mostrar() {
		if (estudiantes.size() == 0) {
			System.out.println("No hay estudiantes en el curso.");
			return;
		}
		for (int i = 0; i < estudiantes.size(); i++) {
			Estudiante estudiante = estudiantes.get(i);
			System.out.println("Notas de " + estudiante.getNombre() + " " + estudiante.getApellido() + ":");
			for (int j = 0; j < estudiante.getNotas().size(); j++) {
				Nota nota = estudiante.getNotas().get(j);
				System.out.println("Curso [ArrayList<Estudiante>=" + nota.getMateria().getNombre() + ", calificacion="
						+ nota.getCalificacion() + "]");
			}
			if (estudiante.getNotas().size() == 0) {
				System.out.println("No tiene notas.");
			}
		}
	}
}

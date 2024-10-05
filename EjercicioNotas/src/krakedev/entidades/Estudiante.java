package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String cedula;
	private ArrayList<Nota> notas;

	public Estudiante(String cedula, String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.notas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public void agregarNota(Nota nuevaNota) {
		if (nuevaNota.getCalificacion() < 0 || nuevaNota.getCalificacion() > 10) {
			System.out.println("Nota no valida: fuera del rango");
			return;
		}
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getMateria().getCodigo().equals(nuevaNota.getMateria().getCodigo())) {
				System.out.println("Error: materia duplicada");
				return;
			}
		}
		notas.add(nuevaNota);
		System.out.println("Nota agregada");
	}

	public void modificarNota(String codigo, double nuevaNota) {
		if (nuevaNota < 0 || nuevaNota > 10) {
			System.out.println("Nota no valida: fuera del rango");
			return;
		}
		boolean notaEncontrada = false;
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getMateria().getCodigo().equals(codigo)) {
				notas.get(i).setCalificacion(nuevaNota);
				System.out.println("Nota modificada");
				notaEncontrada = true;
				break;
			}
		}
		if (notaEncontrada != true) {
			System.out.println("No se encontró el código de materia");
		}
	}
	
	public double calcularPromedioNotasEstudiante() {
		if(notas.size()==0) {
			System.out.println("No hay notas registradas");
			return 0.0;
		}
		double suma=0.0;
		for (int i = 0; i < notas.size(); i++) {
			suma+=notas.get(i).getCalificacion();
			
		}
		double promedio=suma/notas.size();
		System.out.println("Promedio:");
		return promedio;
	}
	
	public void mostrar() {
        System.out.println("Estudiante [nombre=" + nombre + ", apellido=" + apellido +", cedula="+cedula+ "]");
        for(int i=0;i<notas.size();i++) {
        	Nota nota=notas.get(i);
        	String materia=nota.getMateria().getNombre();
        	double calificacion=nota.getCalificacion();
        	System.out.println("Nota[materia="+materia+", calificacion="+calificacion+ "]");
        }
    }

}

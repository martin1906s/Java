package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Directorio {
	private ArrayList<Contacto> contactos;
	private Date fechaModificacion;
	private ArrayList<Contacto> correctos;
	private ArrayList<Contacto> incorrectos;

	public Directorio() {
		this.contactos = new ArrayList<>();
        this.correctos = new ArrayList<>();
        this.incorrectos = new ArrayList<>();
	}
	
	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}

	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public boolean agregarContacto(Contacto contacto) {
		for (int i = 0; i < contactos.size(); i++) {
			if (contactos.get(i).getCedula().equals(contacto.getCedula())) {
				return false;
			}
		}
		contactos.add(contacto);
		return true;
	}

	public Contacto buscarPorCedula(String cedula) {
		for (int i = 0; i < contactos.size(); i++) {
			Contacto contactoEncontrado = contactos.get(i);
			if (contactoEncontrado.getCedula().equals(cedula)) {
				return contactoEncontrado;
			}
		}
		return null;
	}

	public String consultarUltimaModificacion() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date fechaActual = new Date();
        return formatoFecha.format(fechaActual);
    }

	public int contarPerdidos(){
		int perdidos=0;
		for(int i=0;i<contactos.size();i++) {
			if(contactos.get(i).getDireccion()==null) {
				perdidos++;
			}
		}
		return perdidos;
	}
	
	public int contarFijos() {
		int fijos=0;
		for(int i=0;i<contactos.size();i++) {
			ArrayList<Telefono> telefonos=contactos.get(i).getTelefonos();
			for(int j=0;j<telefonos.size();j++) {
				Telefono telefono=telefonos.get(j);
				if(telefono.getTipo().equals("Convencional")&&telefono.getEstado().equals("C")) {
					fijos++;
				}
			}
		}
		return fijos;
	}
	
	public void depurar() {
		for(int i=0;i<contactos.size();i++) {
			Contacto contacto=contactos.get(i);
			if(contacto.getDireccion()!=null) {
				correctos.add(contacto);
			}else {
				incorrectos.add(contacto);
			}
			
		}
		contactos.clear();
	}
}

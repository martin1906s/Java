package com.cmc.directorio.entidades;

public class AdminTelefono {
	public void actrivarMensajeria(Telefono telefono) {
		if(telefono.getOperadora()=="Movi") {
			telefono.setTieneWhatsapp(true);
		}
	}
	public int contarMovi(Telefono t1, Telefono t2, Telefono t3) {
		int esMovi=0;
		if(t1.getOperadora()=="Movi") {
			esMovi+=1;
		}
		if(t2.getOperadora()=="Movi") {
			esMovi+=1;
		}
		if(t3.getOperadora()=="Movi") {
			esMovi+=1;
		}
		return esMovi;
	}
	
	public int contarClaro(Telefono t1, Telefono t2, Telefono t3, Telefono t4) {
		int esClaro=0;
		if(t1.getOperadora()=="Claro") {
			esClaro+=1;
		}
		if(t2.getOperadora()=="Claro") {
			esClaro+=1;
		}
		if(t3.getOperadora()=="Claro") {
			esClaro+=1;
		}
		if(t4.getOperadora()=="Claro") {
			esClaro+=1;
		}
		return esClaro;
	}
}

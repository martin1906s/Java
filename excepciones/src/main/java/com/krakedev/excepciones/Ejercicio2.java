package com.krakedev.excepciones;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {
	public void metodo1() {
		String a=null;
		a.substring(0);
	}
	public void metodo2() {
		File f=new File("archivo.txt");
		try {
			f.createNewFile();
		}catch(IOException io) {
			System.out.println("Error");
		}
	}
	
	public void metodo3() throws IOException{
		File f=new File("archivo.txt");
		f.createNewFile();
	}
	
	public void metodo4() {
		try {
			metodo3();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.krakedev.reto33;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFechas {
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String fechaStr="2007/06/19 10:05:23";
		try {
			Date fecha=sdf.parse(fechaStr);
			System.out.println(fecha);
			long fechaMilis=fecha.getTime();
			System.out.println(fechaMilis);
			/*cres un java.sql.Date patriendo de un java.util.Date
			 * sirve para convertir fecha de java a sql*/
			java.sql.Date fechaSql=new java.sql.Date(fechaMilis);
			System.out.println(fechaSql);
			
			java.sql.Time tSQL=new java.sql.Time(fechaMilis);
			System.out.println(tSQL);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}

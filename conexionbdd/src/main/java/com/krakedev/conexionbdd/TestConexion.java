package com.krakedev.conexionbdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexion {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","martin1906s");
			System.out.println("Conexion exitosa");
			ps=connection.prepareStatement("INSERT INTO usuario (cedula, nombre, apellido, tipo_cuenta,limite_credito) VALUES (?,?,?,?,?)");
			ps.setString(1, "17156");
			ps.setString(2, "Martín");
			ps.setString(3, "Simabaña");
			ps.setString(4, "Ahorros");
			ps.setBigDecimal(5, new BigDecimal(4000));

			
			
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
				ps.setDate(3, fechaSql);
				ps.setBigDecimal(4, new BigDecimal(4500));
				ps.executeUpdate();
				System.out.println("ejecuta insert");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}

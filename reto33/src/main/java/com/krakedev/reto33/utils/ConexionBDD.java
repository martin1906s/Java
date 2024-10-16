package com.krakedev.reto33.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionBDD {
	private final static String Driver="org.postgresql.Driver";
	private final static String URL="jdbc:postgresql://localhost:5432/postgres";
	private final static String USER="postgres";
	private final static String PASSWORD="martin1906s";
	private static final Logger LOGGER=LogManager.getLogger(ConexionBDD.class); 

	public static Connection conectar() throws Exception{
		Connection connection=null;
		try {
			Class.forName(Driver);
			connection = DriverManager.getConnection(URL, USER,PASSWORD);

		} catch (ClassNotFoundException e) {
			LOGGER.error("Error de infraestrucctura",e);
			throw new Exception("Error de infraestrucctura");
		} catch (SQLException e) {
			LOGGER.error("Revise usuario y contraseña",e);
			throw new Exception("Revise usuario y contraseña");
		}finally {
			
		}
		return connection;
	}
}

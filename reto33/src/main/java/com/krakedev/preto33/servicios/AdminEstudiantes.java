package com.krakedev.preto33.servicios;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.reto33.entidades.Estudiante;
import com.krakedev.reto33.utils.ConexionBDD;

public class AdminEstudiantes {
	private static final Logger LOGGER = LogManager.getLogger(AdminEstudiantes.class);

	public static void insertar(com.krakedev.reto33.entidades.Estudiante estudiante) throws Exception {
		Connection con = null;
		PreparedStatement ps;
		try {
			con = ConexionBDD.conectar();

			ps = con.prepareStatement(
					"INSERT INTO estudiantes (cedula, nombre, apellido, email, fecha_nacimineto) VALUES (?,?,?,?,?)");
			ps.setString(1, estudiante.getCedula());
			ps.setString(2, estudiante.getNombre());
			ps.setString(3, estudiante.getApellido());
			ps.setString(4, estudiante.getEmail());
			ps.setDate(5, new java.sql.Date(estudiante.getFechaNac().getTime()));
			

			ps.executeUpdate();

		} catch (Exception e) {
			// Muestra error al usuario
			// loggea el error
			LOGGER.error("Error al insertar", e);
			throw new Exception("Error al insertar");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");

			}
		}
	}

	public static void actualizar(Estudiante estudiante) throws Exception {
		Connection con = null;
		String actualizar = "update estudiantes set nombre=?, apellido=? where cedula=?";
		PreparedStatement ps;

		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(actualizar);
			ps.setString(1, estudiante.getNombre());
			ps.setString(2, estudiante.getApellido());
			ps.setString(3, estudiante.getCedula());
			ps.executeUpdate();

		} catch (Exception e) {
			LOGGER.error("Error al actualizar ", e);
			throw new Exception("Error al actualizar");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}
	}

	public static void eliminar(String cedula) throws Exception {
		Connection con=null;
		String eliminar="delete from estudiantes where cedula=?";
		PreparedStatement ps;

		try {
			con=ConexionBDD.conectar();
			ps=con.prepareStatement(eliminar);
			ps.setString(1, cedula);
			ps.executeUpdate();
			}catch(Exception e) {
				LOGGER.error("Error al eliminar",e);
				throw new Exception("Error al eliminar");
				
			}finally {
				con.close();
			}
		
	}
}

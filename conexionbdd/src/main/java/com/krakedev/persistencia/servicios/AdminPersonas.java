package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminPersonas {
	private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);

	public static void insertar(Persona persona) throws Exception {
		Connection con = null;
		PreparedStatement ps;
		try {
			con = ConexionBDD.conectar();

			ps = con.prepareStatement(
					"INSERT INTO persona (cedula, nombre, apellido, estatura, fecha_nacimiento, hora_nacimiento, cantidad_ahorrada, numero_hijos) VALUES (?,?,?,?,?,?,?,?)");
			ps.setString(1, persona.getCedula().getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setDouble(4, persona.getEstatura());
			ps.setDate(5, new java.sql.Date(persona.getFechaNac().getTime()));
			ps.setTime(6, new Time(persona.getHoraNac().getTime()));
			ps.setBigDecimal(7, persona.getCantidadAhorrada());
			ps.setInt(8, persona.getNumeroHijos());

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

	public static void actualizar(Persona persona) throws Exception {
		Connection con = null;
		String actualizar = "update persona set nombre=?, apellido=? where cedula=?";
		PreparedStatement ps;

		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(actualizar);
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setString(3, persona.getCedula().getCedula());
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
		String eliminar="delete from persona where cedula=?";
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

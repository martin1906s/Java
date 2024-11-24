package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.CabeceraVentas;
import com.krakedev.inventarios.entidades.DetalleVentas;
import com.krakedev.inventarios.excepciones.KrakedevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class VentasBDD {
	public void guardarVenta(CabeceraVentas cabV) throws KrakedevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		PreparedStatement psCab = null;
		PreparedStatement psHistorial = null;
		Date fechaActual = new Date();
		Timestamp fechaHoraActual = new Timestamp(fechaActual.getTime());
		ResultSet rsClaveCab = null;
		int codigoCabecera = 0;
		DetalleVentas det = new DetalleVentas();
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into cabecera_venta(fecha,total_sin_iva,iva,total) values(?,0,0,0);",
					Statement.RETURN_GENERATED_KEYS);
			ps.setTimestamp(1, fechaHoraActual);
			ps.executeUpdate();
			rsClaveCab = ps.getGeneratedKeys();

			if (rsClaveCab.next()) {
				codigoCabecera = rsClaveCab.getInt(1);
			}

			ArrayList<DetalleVentas> detallesVentas = cabV.getDetalles();
			BigDecimal subtotalIva;
			BigDecimal subtotalAcumulado = BigDecimal.ZERO;
			BigDecimal ivaAcumulado = BigDecimal.ZERO;

			for (int i = 0; i < detallesVentas.size(); i++) {
				det = detallesVentas.get(i);
				psDet = con.prepareStatement(
						"insert into detalle_venta(cabecera_venta,producto,cantidad,precio_venta,subtotal,subtotal_con_iva) values(?,?,?,?,?,?) returning codigo");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigo());
				psDet.setInt(3, det.getCantidad());
				psDet.setBigDecimal(4, det.getProducto().getPrecioVenta());
				BigDecimal cantidad = new BigDecimal(det.getCantidad());
				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal subtotal = pv.multiply(cantidad);
				psDet.setBigDecimal(5, subtotal);
				if (det.getProducto().isTieneIVA()) {
					subtotalIva = subtotal.multiply(new BigDecimal(1.12));
					ivaAcumulado = ivaAcumulado.add(subtotal.multiply(new BigDecimal(0.12)));
					subtotalAcumulado = subtotalAcumulado.add(subtotalIva);
				} else {
					subtotalIva = subtotal;
					subtotalAcumulado = subtotalAcumulado.add(subtotalIva);
				}
				psDet.setBigDecimal(6, subtotalIva);
				ResultSet rsDet = psDet.executeQuery();
			    int codigoDetalle = 0;
			    if (rsDet.next()) {
			        codigoDetalle = rsDet.getInt("codigo");
			        System.out.println("Código generado para detalle: " + codigoDetalle);
			    }
				

				psCab = con
						.prepareStatement("update cabecera_venta set total_sin_iva=? , iva=? , total=? where codigo=?");
				psCab.setBigDecimal(1, subtotalIva);
				psCab.setBigDecimal(2, ivaAcumulado);
				psCab.setBigDecimal(3, subtotalIva.add(ivaAcumulado));
				psCab.setInt(4, codigoCabecera);
				psCab.executeUpdate();
				psHistorial = con.prepareStatement(
						"insert into historial_stock(fecha,referencia,producto,cantidad) values(?,?,?,?)");
				psHistorial.setTimestamp(1, fechaHoraActual);
				psHistorial.setString(2, "Venta " + codigoDetalle);
				psHistorial.setInt(3, det.getProducto().getCodigo());
				psHistorial.setInt(4, det.getCantidad() * -1);
				psHistorial.executeUpdate();

			}

		} catch (KrakedevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevException("Error al guardar Ventas. Detalle: " + e.getMessage());
		}
	}
}

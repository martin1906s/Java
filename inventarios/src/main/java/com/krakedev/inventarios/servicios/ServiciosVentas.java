package com.krakedev.inventarios.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.VentasBDD;
import com.krakedev.inventarios.entidades.CabeceraVentas;
import com.krakedev.inventarios.excepciones.KrakedevException;

@Path("ventas")
public class ServiciosVentas {
	@Path("guardar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardar(CabeceraVentas cabV) {
		VentasBDD venta = new VentasBDD();
		try {
			venta.guardarVenta(cabV);
			return Response.ok().build();
		} catch (KrakedevException e) {
			System.out.println(e);
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
}

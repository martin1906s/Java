package com.cmc.evaluacion.servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.Utilitario;
import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;

public class CalculadoraAmortizacion {
	public static double calcularCuota(Prestamo prestamo) {
		double interesMensual = (prestamo.getInteres() / 12) / 100;
		double cuota = (prestamo.getMonto() * interesMensual)
				/ (1 - Math.pow(1 + interesMensual, -prestamo.getPlazo()));
		return Utilitario.redondear(cuota);
	}

	public static void generarTabla(Prestamo prestamo) {
		double cuota = calcularCuota(prestamo);
		ArrayList<Cuota> cuotas = prestamo.getCuotas();

		for (int i = 0; i < prestamo.getPlazo(); i++) {
			Cuota cuotaActual = new Cuota(i + 1);
			cuotaActual.setCuota(cuota);
			cuotas.add(cuotaActual);
		}

		cuotas.get(0).setInicio(prestamo.getMonto());
		for (int i = 0; i < cuotas.size(); i++) {
			Cuota cuotaActual = cuotas.get(i);
			Cuota cuotaSiguiente = (i < cuotas.size() - 1) ? cuotas.get(i + 1) : null;
			calcularValoresCuota(prestamo.getInteres() / 100 / 12, cuotaActual, cuotaSiguiente);
		}

		Cuota ultimaCuota = cuotas.get(cuotas.size() - 1);
		ultimaCuota.setSaldo(0);
	}

	public static void calcularValoresCuota(double interes, Cuota cuotaActual, Cuota cuotaSiguiente) {
		double valorInicio = cuotaActual.getInicio();
		double valorCuota = cuotaActual.getCuota();
		double interesCuota = valorInicio * interes;
		cuotaActual.setInteres(interesCuota);
		double abonoCapital = valorCuota - interesCuota;
		cuotaActual.setAbonoCapital(abonoCapital);
		double saldo = valorInicio - abonoCapital;
		cuotaActual.setSaldo(saldo);

		if (cuotaSiguiente != null) {
			cuotaSiguiente.setInicio(saldo);
		}
	}

	public static void mostrarTabla(Prestamo prestamo) {
		ArrayList<Cuota> cuotas = prestamo.getCuotas();
		System.out.println("Número | Cuota    | Inicio   | Interes | Abono |Saldo");
		System.out.println("------------------------------------------------------");

		for (int i = 0; i < cuotas.size(); i++) {
			Cuota cuota = cuotas.get(i);
			System.out.println(cuotas.get(i).getNumero() + "      | " + Utilitario.redondear(cuotas.get(i).getCuota())
					+ "   |" + Utilitario.redondear(cuotas.get(i).getInicio()) + "   |"
					+ Utilitario.redondear(cuotas.get(i).getInteres()) + "    |"
					+ Utilitario.redondear(cuotas.get(i).getAbonoCapital()) + " |"
					+ Utilitario.redondear(cuotas.get(i).getSaldo()));
		}
	}
}

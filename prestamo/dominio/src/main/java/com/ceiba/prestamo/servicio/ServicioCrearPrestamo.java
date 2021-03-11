package com.ceiba.prestamo.servicio;

import java.util.Date;

import com.ceiba.prestamo.modelo.entidad.CalcularFechaFinal;
import com.ceiba.prestamo.modelo.entidad.CalcularIntereses;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.dao.DaoPrestamo;
import com.ceiba.prestamo.puerto.respositorio.RespositorioPrestamo;

public class ServicioCrearPrestamo {

	private final RespositorioPrestamo repositorioPrestamo;
	private final DaoPrestamo daoPrestamo;

	public ServicioCrearPrestamo(RespositorioPrestamo repositorioUsuario, DaoPrestamo daoPrestamo) {
		this.repositorioPrestamo = repositorioUsuario;
		this.daoPrestamo = daoPrestamo;

	}

	public Long ejecutar(Prestamo prestamo) {

		Date fechaActual = new Date();

		CalcularIntereses calcularIntereses = new CalcularIntereses(prestamo.getValor());
		CalcularFechaFinal calcularFechaFinal = new CalcularFechaFinal(prestamo.getFechaInicial());

		double valorPrestamosActivos = this.daoPrestamo.valorToltalPrestamosActivos(fechaActual);
		prestamo.validarFondosDisponible(valorPrestamosActivos);

		int cantidadPrestamosCliente = this.daoPrestamo.contarPrestamosActivosPorCliente(prestamo.getDocumentoCliente(),
				fechaActual);
		prestamo.validarCantidadPrestamosCliente(cantidadPrestamosCliente);

		double valorPrestamosCliente = this.daoPrestamo.valorPrestamosCliente(prestamo.getDocumentoCliente(),
				fechaActual);
		prestamo.validarCupoCliente(valorPrestamosCliente);

		prestamo.calcularValorApagar(prestamo.getValor(), calcularIntereses);

		prestamo.calcularFechaFinalPrestamo(calcularFechaFinal);

		return this.repositorioPrestamo.crear(prestamo);
	}

}

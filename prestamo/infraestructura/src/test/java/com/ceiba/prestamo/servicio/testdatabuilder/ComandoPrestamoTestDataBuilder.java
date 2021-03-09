package com.ceiba.prestamo.servicio.testdatabuilder;

import java.util.Date;

import com.ceiba.prestamo.comando.ComandoPrestamo;

public class ComandoPrestamoTestDataBuilder {

	private Long id;
	private Long documentoCliente;
	private double valor;
	private float porcentajeInteres;
	private double valorInteres;
	private double valorApagar;
	private Date fechaInicial;
	private Date fechaFinal;

	public ComandoPrestamoTestDataBuilder() {
		documentoCliente = (long) 123456789;
		valor = 50000;
		fechaInicial = new Date();
	}

	public ComandoPrestamoTestDataBuilder conDocumentoCliente(Long documentoCliente) {
		this.documentoCliente = documentoCliente;
		return this;
	}

	public ComandoPrestamo build() {
		return new ComandoPrestamo(id, documentoCliente, valor, porcentajeInteres, valorInteres, valorApagar,
				fechaInicial, fechaFinal);
	}

}

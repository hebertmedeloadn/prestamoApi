package com.ceiba.prestamo.servicio.testdatabuilder;

import java.util.Date;

import com.ceiba.prestamo.comando.ComandoPrestamo;

public class ComandoPrestamoTestDataBuilder {

	private Long documentoCliente;
	private double valor;
	private Date fechaInicial;

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
		return new ComandoPrestamo(documentoCliente, valor, fechaInicial);
	}

}

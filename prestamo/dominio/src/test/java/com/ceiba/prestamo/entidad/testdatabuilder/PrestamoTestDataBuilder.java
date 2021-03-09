package com.ceiba.prestamo.entidad.testdatabuilder;

import com.ceiba.prestamo.modelo.entidad.Prestamo;

import java.time.LocalDateTime;
import java.util.Date;

public class PrestamoTestDataBuilder {

	private Long id;
	private Long documentoCliente;
	private double valor;
	private float porcentajeInteres;
	private double valorInteres;
	private double valorApagar;
	private Date fechaInicial;
	private Date fechaFinal;

	public PrestamoTestDataBuilder() {
		documentoCliente = (long) 123456;
		valor = 50000;
		fechaInicial = new Date();
	}

	public PrestamoTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public PrestamoTestDataBuilder conDocumentoCliente(Long documentoCliente) {
		this.documentoCliente = documentoCliente;
		return this;
	}

	public PrestamoTestDataBuilder conValor(double valor) {
		this.valor = valor;
		return this;
	}

	public PrestamoTestDataBuilder conPorcentajeInteres(Long porcentajeInteres) {
		this.porcentajeInteres = porcentajeInteres;
		return this;
	}

	public PrestamoTestDataBuilder conValorInteres(double valorInteres) {
		this.valorInteres = valorInteres;
		return this;
	}

	public PrestamoTestDataBuilder conValorApagar(double valorApagar) {
		this.valorApagar = valorApagar;
		return this;
	}

	public PrestamoTestDataBuilder conFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
		return this;
	}

	public PrestamoTestDataBuilder conFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
		return this;
	}

	public Prestamo build() {
		return new Prestamo(id, documentoCliente, valor, porcentajeInteres, valorInteres, valorApagar, fechaInicial,
				fechaFinal);
	}
}

package com.ceiba.prestamo.entidad.testdatabuilder;

import com.ceiba.prestamo.modelo.entidad.CalcularInteresesImpl;

public class CalcularInteresTestDataBuilder {

	private double valorPrestamo;

	public CalcularInteresTestDataBuilder() {
		valorPrestamo = 10000;
	}

	public CalcularInteresTestDataBuilder conValorPrestamo(double valorPrestamo) {
		this.valorPrestamo = valorPrestamo;
		return this;
	}

	public CalcularInteresesImpl build() {
		return new CalcularInteresesImpl(valorPrestamo);
	}

}

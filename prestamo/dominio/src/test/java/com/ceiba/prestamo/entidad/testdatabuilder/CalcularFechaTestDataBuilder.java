package com.ceiba.prestamo.entidad.testdatabuilder;

import java.util.Date;

import com.ceiba.prestamo.modelo.entidad.CalcularFechaFinal;

public class CalcularFechaTestDataBuilder {

	private Date fechaInicial;

	public CalcularFechaTestDataBuilder() {
		fechaInicial = new Date(); 
	}	
	
	public CalcularFechaTestDataBuilder conFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
		return this;
	}

	public CalcularFechaFinal build() {
		return new CalcularFechaFinal(fechaInicial); 
	}

	
}

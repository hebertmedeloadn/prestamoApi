package com.ceiba.prestamo.entidad;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.prestamo.entidad.testdatabuilder.CalcularFechaTestDataBuilder;
import com.ceiba.prestamo.modelo.entidad.CalcularFechaFinal;

public class CalcularFechaFinalTest {
	@Test
	public void esDomingo() {
		// arrange
		LocalDateTime esDomigo = LocalDateTime.of(2020, 3, 7, 0, 0);
		CalcularFechaFinal calcularFechaFinal = new CalcularFechaTestDataBuilder().build();
		// act - assert
		Assert.assertTrue(calcularFechaFinal.esDomingo(esDomigo));

	}
	
	@Test
	public void calcularFechaFinalPrestamo() {
		// arrange
		Date  fechaInical = new Date(121, 2, 6);
		CalcularFechaFinal calcularFechaFinal = new CalcularFechaTestDataBuilder().conFechaInicial(fechaInical).build();	
		Date fechaFinal = calcularFechaFinal.calcularFechaFinalPrestamo();
		// act
		Date fechaComparar =  new Date(121, 3, 6);
		// assert
		Assert.assertEquals(fechaComparar, fechaFinal);

	}
}

package com.ceiba.prestamo.entidad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public void noEsDomigo() {
		// arrange
		LocalDateTime noEsDomigo = LocalDateTime.of(2020, 3, 8, 0, 0);
		CalcularFechaFinal calcularFechaFinal = new CalcularFechaTestDataBuilder().build();
		// act - assert
		Assert.assertFalse(calcularFechaFinal.esDomingo(noEsDomigo));
	}

	@Test
	public void calcularFechaFinalPrestamo() throws ParseException {
		// arrange
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInical = formato.parse("2020-03-08");

		CalcularFechaFinal calcularFechaFinal = new CalcularFechaTestDataBuilder().conFechaInicial(fechaInical).build();
		Date fechaFinal = calcularFechaFinal.calcularFechaFinalPrestamo();
		// act
		Date fechaComparar = calcularFechaFinal.convertirLocalDateTimeADate(LocalDateTime.of(2020, 4, 8, 0, 0));
		// assert
		Assert.assertEquals(fechaComparar, fechaFinal);

	}
	
	@Test
	public void calcularFechaFinalPrestamoConDomigo() throws ParseException {
		// arrange
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInical = formato.parse("2020-02-07");

		CalcularFechaFinal calcularFechaFinal = new CalcularFechaTestDataBuilder().conFechaInicial(fechaInical).build();
		Date fechaFinal = calcularFechaFinal.calcularFechaFinalPrestamo();
		// act
		Date fechaComparar = calcularFechaFinal.convertirLocalDateTimeADate(LocalDateTime.of(2020, 3, 8, 0, 0));
		// assert
		Assert.assertEquals(fechaComparar, fechaFinal);

	}
}

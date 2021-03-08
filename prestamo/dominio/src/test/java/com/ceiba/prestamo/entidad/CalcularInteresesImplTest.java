package com.ceiba.prestamo.entidad;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.prestamo.entidad.testdatabuilder.CalcularInteresTestDataBuilder;
import com.ceiba.prestamo.modelo.entidad.CalcularInteresesImpl;

public class CalcularInteresesImplTest {

	private static final float PORCENTAJE_MAXIMO_INTERES = 7;

	@Test
	public void clacularPorcentajeInteres() {
		// arrange
		double valorPrestamo = 100000;
		CalcularInteresesImpl calcularIntereses = new CalcularInteresTestDataBuilder().conValorPrestamo(valorPrestamo)
				.build();
		float porcentejeInteres = calcularIntereses.clacularPorcentajeInteres();
		// act
		float porcentajeMinimoInteres = PORCENTAJE_MAXIMO_INTERES;
		// assert
		Assert.assertEquals(porcentejeInteres, porcentajeMinimoInteres, 0.0);

	}

	@Test
	public void clacularValorInteres() {
		// arrange
		double valorPrestamo = 100000;
		CalcularInteresesImpl calcularIntereses = new CalcularInteresTestDataBuilder().conValorPrestamo(valorPrestamo)
				.build();
		double valorInteres = calcularIntereses.clacularValorInteres(PORCENTAJE_MAXIMO_INTERES);
		// act
		double valorComparar = 7000;
		// assert
		Assert.assertEquals(valorInteres, valorComparar, 0.0);
	}	
}

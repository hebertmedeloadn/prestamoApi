package com.ceiba.prestamo.entidad;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.prestamo.entidad.testdatabuilder.CalcularInteresTestDataBuilder;
import com.ceiba.prestamo.modelo.entidad.CalcularIntereses;

public class CalcularInteresesImplTest {

	private static final float PORCENTAJE_MINIMO_INTERES = 7;
	private static final float PORCENTAJE_MAXIMO_INTERES = 10;

	@Test
	public void clacularPorcentajeInteresMinimo() {
		// arrange
		double valorPrestamo = 300000;
		CalcularIntereses calcularIntereses = new CalcularInteresTestDataBuilder().conValorPrestamo(valorPrestamo)
				.build();
		float porcentejeInteres = calcularIntereses.clacularPorcentaje();
		// act
		float porcentajeMinimoInteres = PORCENTAJE_MINIMO_INTERES;
		// assert
		Assert.assertEquals(porcentejeInteres, porcentajeMinimoInteres, 0.0);

	}

	@Test
	public void clacularPorcentajeMaximo() {
		// arrange
		double valorPrestamo = 100000;
		CalcularIntereses calcularIntereses = new CalcularInteresTestDataBuilder().conValorPrestamo(valorPrestamo)
				.build();
		float porcentejeInteres = calcularIntereses.clacularPorcentaje();
		// act
		float porcentajeMinimoInteres = PORCENTAJE_MAXIMO_INTERES;
		// assert
		Assert.assertEquals(porcentejeInteres, porcentajeMinimoInteres, 0.0);

	}

	@Test
	public void clacularValorInteres() {
		// arrange
		double valorPrestamo = 300000;
		CalcularIntereses calcularIntereses = new CalcularInteresTestDataBuilder().conValorPrestamo(valorPrestamo)
				.build();
		double valorInteres = calcularIntereses.calcularValor(PORCENTAJE_MAXIMO_INTERES);
		// act
		double valorComparar = 30000;
		// assert
		Assert.assertEquals(valorInteres, valorComparar, 0.0);
	}
}

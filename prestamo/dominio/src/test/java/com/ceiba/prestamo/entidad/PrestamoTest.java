package com.ceiba.prestamo.entidad;

import org.junit.jupiter.api.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.servicio.PrestamoTestDataBuilder;

public class PrestamoTest {
	
	private static final String FONDOS_INSUFICIENTES = "Fondos insuficientes. Quedan fondos por un valor de ";
	
	@Test
	public void validarFondosDisponible() {
		// arrange
		double valorPrestamo = 100000;
		Prestamo prestamo = new PrestamoTestDataBuilder().conValor(valorPrestamo).build();
		int disponiblidadFondos = 200000;
		// act - assert
		BasePrueba.assertThrows(() -> prestamo.validarFondosDisponible(disponiblidadFondos),
				ExcepcionValorInvalido.class, FONDOS_INSUFICIENTES);

	}

}

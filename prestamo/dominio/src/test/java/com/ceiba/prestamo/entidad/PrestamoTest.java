package com.ceiba.prestamo.entidad;

import org.junit.jupiter.api.Test;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.servicio.PrestamoTestDataBuilder;

public class PrestamoTest {

	private static final String FONDOS_INSUFICIENTES = "Fondos insuficientes";
	private static final String EL_CLIENTE_SOLO_PUEDE_TENER_TRES_PRESTAMOS = "Un mismo cliente solo puede tener tres prestamos";
	private static final String CLIENTE_EXEDIO_EL_CUPO = "El cliente exedio el cupo permitido";

	@Test
	public void validarFondosDisponible() {
		// arrange
		double valorPrestamo = 300000;
		Prestamo prestamo = new PrestamoTestDataBuilder().conValor(valorPrestamo).build();
		int valorPrestamosActivos = 4800000;
		// act - assert
		BasePrueba.assertThrows(() -> prestamo.validarFondosDisponible(valorPrestamosActivos),
				ExcepcionValorInvalido.class, FONDOS_INSUFICIENTES);

	}

	@Test
	public void validarCantidadPrestamosCliente() {
		// arrange
		int cantidadPrestamos = 3;
		Prestamo prestamo = new PrestamoTestDataBuilder().build();
		int disponiblidadPrestamos = 3;
		// act - assert
		BasePrueba.assertThrows(() -> prestamo.validarCantidadPrestamosCliente(disponiblidadPrestamos),
				ExcepcionValorInvalido.class, EL_CLIENTE_SOLO_PUEDE_TENER_TRES_PRESTAMOS);

	}
	
//	@Test
//	public void validarCupoCliente() {
//		// arrange
//		double valorPrestamo = 300000;
//		Prestamo prestamo = new PrestamoTestDataBuilder().conValor(valorPrestamo).build();
//		int valorPrestamosActivos = 4800000;
//		// act - assert
//		BasePrueba.assertThrows(() -> prestamo.validarCupoCliente(valorPrestamosActivos),
//				ExcepcionValorInvalido.class, FONDOS_INSUFICIENTES);
//
//	}

}

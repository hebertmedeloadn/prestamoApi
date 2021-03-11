package com.ceiba.prestamo.entidad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.prestamo.entidad.testdatabuilder.PrestamoTestDataBuilder;
import com.ceiba.prestamo.modelo.entidad.CalcularFechaFinal;
import com.ceiba.prestamo.modelo.entidad.CalcularIntereses;
import com.ceiba.prestamo.modelo.entidad.Prestamo;

public class PrestamoTest {

	private static final String FONDOS_INSUFICIENTES = "Fondos insuficientes";
	private static final String EL_CLIENTE_SOLO_PUEDE_TENER_TRES_PRESTAMOS = "Un mismo cliente solo puede tener tres prestamos";
	private static final String CLIENTE_EXEDIO_EL_CUPO = "El cliente exedio el cupo permitido";

	private static final double VALOR_MINIMO_PRESTAMO = 50000;
	private static final double VALOR_MAXIMO_PRESTAMO = 500000;
	private static final String SE_DEBE_INGRESAR_UN_VALOR_MAYOR_IGUAL_CINCUENTAMIL = "El valor del prestamo no debe ser menor a "
			+ VALOR_MINIMO_PRESTAMO;
	private static final String SE_DEBE_INGRESAR_UN_VALOR_MENOR_IGUAL_QUINIENTOSMIL = "El valor del prestamo no debe ser mayor a "
			+ VALOR_MAXIMO_PRESTAMO;

	@Test
	public void validarMontoMinimoPrestamo() {
		// arrange
		double valorPrestamo = 20000;
		// act - assert
		BasePrueba.assertThrows(() -> new PrestamoTestDataBuilder().conValor(valorPrestamo).build(),
				ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UN_VALOR_MAYOR_IGUAL_CINCUENTAMIL);
	}
	
	@Test
	public void validarMontoMaximoPrestamo() {
		// arrange
		double valorPrestamo = 600000;
		// act - assert
		BasePrueba.assertThrows(() -> new PrestamoTestDataBuilder().conValor(valorPrestamo).build(),
				ExcepcionValorInvalido.class, SE_DEBE_INGRESAR_UN_VALOR_MENOR_IGUAL_QUINIENTOSMIL);
	}

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
		Prestamo prestamo = new PrestamoTestDataBuilder().build();
		int disponiblidadPrestamos = 3;
		// act - assert
		BasePrueba.assertThrows(() -> prestamo.validarCantidadPrestamosCliente(disponiblidadPrestamos),
				ExcepcionValorInvalido.class, EL_CLIENTE_SOLO_PUEDE_TENER_TRES_PRESTAMOS);

	}

	@Test
	public void validarCupoCliente() {
		// arrange
		double valorPrestamo = 200000;
		Prestamo prestamo = new PrestamoTestDataBuilder().conValor(valorPrestamo).build();
		int valorPrestamosCliente = 400000;
		// act - assert
		BasePrueba.assertThrows(() -> prestamo.validarCupoCliente(valorPrestamosCliente), ExcepcionValorInvalido.class,
				CLIENTE_EXEDIO_EL_CUPO);
	}

	@Test
	public void calcularValorApagar() {
		// arrange
		double valorPrestamo = 100000;
		Prestamo prestamo = new PrestamoTestDataBuilder().conValor(valorPrestamo).build();

		CalcularIntereses calcularInteres = Mockito.mock(CalcularIntereses.class);

		Mockito.when(calcularInteres.clacularPorcentaje()).thenReturn((float) 10);
		Mockito.when(calcularInteres.calcularValor(10)).thenReturn((double) 10000);

		double apagarTotal = valorPrestamo + 10000;

		// act
		prestamo.calcularValorApagar(valorPrestamo, calcularInteres);

		// assert
		Assert.assertEquals(prestamo.getValorApagar(), apagarTotal, 0.0);
	}

	@Test
	public void calcularFechaFinalPrestamo() throws ParseException {
		// arrange
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInical = formato.parse("2020-03-08");

		Prestamo prestamo = new PrestamoTestDataBuilder().conFechaInicial(fechaInical).build();

		CalcularFechaFinal calcularFechaFinal = Mockito.mock(CalcularFechaFinal.class);
		Mockito.when(calcularFechaFinal.calcularFechaFinalPrestamo()).thenReturn(formato.parse("2020-04-08"));

		// act
		prestamo.calcularFechaFinalPrestamo(calcularFechaFinal);

		// assert
		Assert.assertEquals(prestamo.getFechaFinal(), calcularFechaFinal.calcularFechaFinalPrestamo());
	}

}

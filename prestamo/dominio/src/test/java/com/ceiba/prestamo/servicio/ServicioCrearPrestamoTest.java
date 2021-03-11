package com.ceiba.prestamo.servicio;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.prestamo.entidad.testdatabuilder.CalcularFechaTestDataBuilder;
import com.ceiba.prestamo.entidad.testdatabuilder.CalcularInteresTestDataBuilder;
import com.ceiba.prestamo.entidad.testdatabuilder.PrestamoTestDataBuilder;
import com.ceiba.prestamo.modelo.entidad.CalcularFechaFinal;
import com.ceiba.prestamo.modelo.entidad.CalcularIntereses;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.dao.DaoPrestamo;
import com.ceiba.prestamo.puerto.respositorio.RespositorioPrestamo;

public class ServicioCrearPrestamoTest {

	@Test
	public void validarRegistro() {

		// arrange
		Long idPrestamo = 1l;
		Prestamo prestamo = new PrestamoTestDataBuilder().conId(idPrestamo).conValor(50000).build();
		CalcularIntereses prestamoIntereses = new CalcularInteresTestDataBuilder().conValorPrestamo(prestamo.getValor())
				.build();
		CalcularFechaFinal calcularFechaFinal = new CalcularFechaTestDataBuilder()
				.conFechaInicial(prestamo.getFechaInicial()).build();

		Prestamo prestamoMock = Mockito.mock(Prestamo.class);
		DaoPrestamo daoPrestamo = Mockito.mock(DaoPrestamo.class);

		Mockito.when(daoPrestamo.valorToltalPrestamosActivos(prestamo.getFechaInicial())).thenReturn(1000000D);
		Mockito.doNothing().when(prestamoMock).validarFondosDisponible(anyDouble());

		Mockito.when(daoPrestamo.contarPrestamosActivosPorCliente(prestamo.getDocumentoCliente(),
				prestamo.getFechaInicial())).thenReturn(2);
		Mockito.doNothing().when(prestamoMock).validarCantidadPrestamosCliente(anyInt());

		Mockito.when(daoPrestamo.valorPrestamosCliente(prestamo.getDocumentoCliente(), prestamo.getFechaInicial()))
				.thenReturn(100000D);
		Mockito.doNothing().when(prestamoMock).validarCupoCliente(anyDouble());

		Mockito.doNothing().when(prestamoMock).calcularValorApagar(prestamo.getValor(), prestamoIntereses);

		Mockito.doNothing().when(prestamoMock).calcularFechaFinalPrestamo(calcularFechaFinal);

		RespositorioPrestamo repositorioPrestamo = Mockito.mock(RespositorioPrestamo.class);
		Mockito.when(repositorioPrestamo.crear(prestamo)).thenReturn(idPrestamo);

		ServicioCrearPrestamo servicioCrearPrestamo = new ServicioCrearPrestamo(repositorioPrestamo, daoPrestamo);

		// Act
		Long idPrestamoGenerado = servicioCrearPrestamo.ejecutar(prestamo);

		// assert

		Assert.assertEquals(idPrestamoGenerado, idPrestamo);

	}

}

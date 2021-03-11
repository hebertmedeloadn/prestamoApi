package com.ceiba.prestamo.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.prestamo.comando.ComandoPrestamo;
import com.ceiba.prestamo.comando.fabrica.FabricaPrestamo;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.servicio.ServicioCrearPrestamo;

@Component
public class ManejadorCrearPrestamo implements ManejadorComandoRespuesta<ComandoPrestamo, ComandoRespuesta<Long>> {

	private final FabricaPrestamo fabricaPrestamo;
	private final ServicioCrearPrestamo servicioCrearPrestamo;

	public ManejadorCrearPrestamo(FabricaPrestamo fabricaPrestamo, ServicioCrearPrestamo servicioCrearPrestamo) {
		this.fabricaPrestamo = fabricaPrestamo;
		this.servicioCrearPrestamo = servicioCrearPrestamo;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoPrestamo comandoPrestamo) {

		Prestamo prestamo = this.fabricaPrestamo.crear(comandoPrestamo);

		return new ComandoRespuesta<>(this.servicioCrearPrestamo.ejecutar(prestamo));
	}

}

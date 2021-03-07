package com.ceiba.prestamo.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.prestamo.comando.ComandoPrestamo;
import com.ceiba.prestamo.modelo.entidad.Prestamo;

@Component
public class FabricaPrestamo {

	public Prestamo crear(ComandoPrestamo comandoPrestamo) {
		return new Prestamo(comandoPrestamo.getDocumentoCliente(), comandoPrestamo.getValor(),
				comandoPrestamo.getFechaInicial());
	}

}

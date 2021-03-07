package com.ceiba.prestamo.puerto.respositorio;

import com.ceiba.prestamo.modelo.entidad.Prestamo;

public interface RespositorioPrestamo {

	/**
	 * Permite crear un Prestamo
	 * 
	 * @param prestamo
	 * @return el id generado
	 */
	Long crear(Prestamo prestamo);
	


}

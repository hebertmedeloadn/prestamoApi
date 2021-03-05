package com.ceiba.prestamo.puerto.dao;

import java.util.List;

import com.ceiba.prestamo.modelo.dto.DtoPrestamo;

public interface DaoPrestamo {
	
	/**
     * Permite listar prestamos
     * @return los prestamos
     */
    List<DtoPrestamo> listar();

}

package com.ceiba.prestamo.puerto.dao;

import java.util.Date;
import java.util.List;

import com.ceiba.prestamo.modelo.dto.DtoPrestamo;

public interface DaoPrestamo {
	
	/**
     * Permite listar prestamos
     * @return los prestamos
     */
    List<DtoPrestamo> listar(Date fechaActual);
    
    /**
     * permite sumar el valor de todos los prestamos activos
     * @param fechaActual
     * @return valor total prestamos activos
     */
    double valorToltalPrestamosActivos(Date fechaActual);
    
    /**
     * permite contar prestamos activos por cliente
     * @param docmuentoCliente
     * @return cantidad de creditos ativos
     */
    int contarPrestamosActivosPorCliente(Long docacumentoCliente, Date fechaActual);
    
    /**
     * permite sumar el valor de todos los prestamos activos de un cliente
     * @param fechaActual
     * @return valor total prestamos activos de un cliente
     */
    double valorPrestamosCliente(Long documentoCliente, Date fechaActual);
}

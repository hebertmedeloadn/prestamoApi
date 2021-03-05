package com.ceiba.prestamo.modelo.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoPrestamo {
	private Long id;
	private Long documentoCliente;
	private double valor;
	private float porcentajeInteres;
	private double valorInteres;
	private double valorApagar;
	private Date fechaInicial;
	private Date fechaFinal;
}

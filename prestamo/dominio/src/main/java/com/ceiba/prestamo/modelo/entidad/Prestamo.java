package com.ceiba.prestamo.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.util.Date;

public class Prestamo {

	private static final String SE_DEBE_INGRESAR_EL_DOCUEMTO_CLIENTE = "Se debe ingresar el docmuento cliente";
	private static final String SE_DEBE_INGRESAR_EL_VALOR_PRESTAMO = "Se debe ingresar el valor del prestamo";
	private static final String SE_DEBE_INGRESAR_EL_PORCENTAJE_INTERES = "Se debe ingresar el porcentaje de interes";
	private static final String SE_DEBE_INGRESAR_EL_VALOR_INTERES = "Se debe ingresar el valor del interes";
	private static final String SE_DEBE_INGRESAR_EL_VALOR_A_PAGAR = "Se debe ingresar el valor apagar";
	private static final String SE_DEBE_INGRESAR_FECHA_INICIAL = "Se debe ingresar la fecha inicial";
	private static final String SE_DEBE_INGRESAR_FECHA_FINAL = "Se debe ingresar la fecha final";

	private Long id;
	private Long documentoCliente;
	private double valor;
	private float porcentajeInteres;
	private double valorInteres;
	private double valorApagar;
	private Date fechaInicial;
	private Date fechaFinal;

	public Prestamo(Long id, Long documentoCliente, double valor, float porcentajeInteres, double valorInteres,
			double valorApagar, Date fechaInicial, Date fechaFinal) {

		validarObligatorio(documentoCliente, SE_DEBE_INGRESAR_EL_DOCUEMTO_CLIENTE);
		validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR_PRESTAMO);
		validarObligatorio(porcentajeInteres, SE_DEBE_INGRESAR_EL_PORCENTAJE_INTERES);
		validarObligatorio(valorInteres, SE_DEBE_INGRESAR_EL_VALOR_INTERES);
		validarObligatorio(valorApagar, SE_DEBE_INGRESAR_EL_VALOR_A_PAGAR);
		validarObligatorio(fechaInicial, SE_DEBE_INGRESAR_FECHA_INICIAL);
		validarObligatorio(fechaFinal, SE_DEBE_INGRESAR_FECHA_FINAL);
		this.id = id;
		this.documentoCliente = documentoCliente;
		this.valor = valor;
		this.porcentajeInteres = porcentajeInteres;
		this.valorInteres = valorInteres;
		this.valorApagar = valorApagar;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}

}

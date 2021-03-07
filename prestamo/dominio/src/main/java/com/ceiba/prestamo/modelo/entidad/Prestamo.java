package com.ceiba.prestamo.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarMenor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import lombok.Getter;

@Getter
public class Prestamo {

	private static final double VALOR_MINIMO_PRESTAMO = 50000;
	private static final double VALOR_MAXIMO_PRESTAMO = 500000;
	private static final double TOTAL_FONDOS = 5000000;
	private static final int TOTAL_PRESTAMOS_CLIENTE = 3;
	private static final double CUPO_CLIENTE = 500000;

	private static final String SE_DEBE_INGRESAR_EL_DOCUEMTO_CLIENTE = "Se debe ingresar el docmuento cliente";
	private static final String SE_DEBE_INGRESAR_EL_VALOR_A_PAGAR = "Se debe ingresar el valor apagar";
	private static final String SE_DEBE_INGRESAR_FECHA_INICIAL = "Se debe ingresar la fecha inicial";

	private static final String SE_DEBE_INGRESAR_UN_VALOR_MAYOR_IGUAL_CINCUENTAMIL = "El valor del prestamo no debe ser menor a "
			+ VALOR_MINIMO_PRESTAMO;
	private static final String SE_DEBE_INGRESAR_UN_VALOR_MENOR_IGUAL_QUINIENTOSMIL = "El valor del prestamo no debe ser mayor a "
			+ VALOR_MAXIMO_PRESTAMO;
	private static final String FONDOS_INSUFICIENTES = "Fondos insuficientes. Quedan fondos por un valor de ";
	private static final String EL_CLIENTE_SOLO_PUEDE_TENER_TRES_PRESTAMOS = "Un mismo cliente solo puede tener tres prestamos";
	private static final String CLIENTE_EXEDIO_EL_CUPO = "El cliente exedio el cupo permitido, tiene un cupo disponible de ";

	private Long id;
	private Long documentoCliente;
	private double valor;
	private float porcentajeInteres;
	private double valorInteres;
	private double valorApagar;
	private Date fechaInicial;
	private Date fechaFinal;

	public Prestamo(Long documentoCliente, double valor, Date fechaInicial) {

		validarObligatorio(documentoCliente, SE_DEBE_INGRESAR_EL_DOCUEMTO_CLIENTE);
		validarMenor((long) VALOR_MINIMO_PRESTAMO, (long) valor, SE_DEBE_INGRESAR_UN_VALOR_MAYOR_IGUAL_CINCUENTAMIL);
		validarMenor((long) valor, (long) VALOR_MAXIMO_PRESTAMO, SE_DEBE_INGRESAR_UN_VALOR_MENOR_IGUAL_QUINIENTOSMIL);
		validarObligatorio(valorApagar, SE_DEBE_INGRESAR_EL_VALOR_A_PAGAR);
		validarObligatorio(fechaInicial, SE_DEBE_INGRESAR_FECHA_INICIAL);

		this.documentoCliente = documentoCliente;
		this.valor = valor;
		this.fechaInicial = fechaInicial;
	}

	public void validarFondosDisponible(double valorPrestamosActivos) {
		double montoTotal = valorPrestamosActivos + this.valor;
		double fondosDisponibles = TOTAL_FONDOS - valorPrestamosActivos;
		if (montoTotal > TOTAL_FONDOS) {
			throw new ExcepcionValorInvalido(FONDOS_INSUFICIENTES + fondosDisponibles);
		}
	}

	public void validarCantidadPrestamosCliente(int cantidadPrestamos) {
		if (cantidadPrestamos >= TOTAL_PRESTAMOS_CLIENTE) {
			throw new ExcepcionValorInvalido(EL_CLIENTE_SOLO_PUEDE_TENER_TRES_PRESTAMOS);
		}
	}

	public void validarCupoCliente(double valorPrestamosCliente) {
		double cupoTotal = valorPrestamosCliente + this.valor;
		double cupoDisponible = CUPO_CLIENTE - valorPrestamosCliente;
		if (cupoTotal > CUPO_CLIENTE) {
			throw new ExcepcionValorInvalido(CLIENTE_EXEDIO_EL_CUPO + cupoDisponible);
		}
	}

	public void calcularValorApagar(double valor, CalcularIntereses intereses) {
		this.porcentajeInteres = intereses.clacularPorcentajeInteres(valor);
		this.valorInteres = intereses.clacularValorInteres(valor, porcentajeInteres);
		this.valorApagar = valor + valorInteres;
	}

	public void calcularFechaFinalPrestamo(CalcularFechaFinal calcularFechaFinal) {
		this.fechaFinal = calcularFechaFinal.calcularFechaFinalPrestamo();
	}

	

}

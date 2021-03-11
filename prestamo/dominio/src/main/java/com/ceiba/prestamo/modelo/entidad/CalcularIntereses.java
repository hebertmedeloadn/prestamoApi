package com.ceiba.prestamo.modelo.entidad;

public class CalcularIntereses {

	private static final double VALOR_BASE_CALCULAR_INTERES = 250000;
	private static final float PORCENTAJE_MAXIMO_INTERES = 10;
	private static final float PORCENTAJE_MINIMO_INTERES = 7;

	private double valor;

	public CalcularIntereses(double valor) {
		this.valor = valor;
	}

	public float clacularPorcentaje() {
		if (valor < VALOR_BASE_CALCULAR_INTERES) {
			return PORCENTAJE_MAXIMO_INTERES;
		}
		return PORCENTAJE_MINIMO_INTERES;
	}

	public double calcularValor(float porsentajeInteres) {
		return valor * porsentajeInteres / 100;
	}

}

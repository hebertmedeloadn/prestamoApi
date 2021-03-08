package com.ceiba.prestamo.modelo.entidad;

public class CalcularInteresesImpl implements CalcularIntereses {

	private static final double VALOR_BASE_CALCULAR_INTERES = 500000;
	private static final float PORCENTAJE_MAXIMO_INTERES = 7;
	private static final float PORCENTAJE_MINIMO_INTERES = 10;

	private double valor;

	public CalcularInteresesImpl(double valor) {
		this.valor = valor;
	}

	@Override
	public float clacularPorcentajeInteres() {
		if (valor < VALOR_BASE_CALCULAR_INTERES) {
			return PORCENTAJE_MAXIMO_INTERES;
		}
		return PORCENTAJE_MINIMO_INTERES;
	}

	@Override
	public double clacularValorInteres(float porsentajeInteres) {
		return valor * porsentajeInteres / 100;
	}

}

package com.ceiba.prestamo.modelo.entidad;

public interface CalcularIntereses {

	/**
	 * Calcula porcentaje de intereses
	 * 
	 * @param valor prestamo
	 * @return porcetaje intereses
	 */
	public float clacularPorcentajeInteres(double valor);

	/**
	 * Calcula el valor de intereses
	 * 
	 * @param valor prestamo
	 * @return valor intereses
	 */
	public double clacularValorInteres(double valor, float porsentajeInteres);

}

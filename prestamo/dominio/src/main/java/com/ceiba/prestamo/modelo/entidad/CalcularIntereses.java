package com.ceiba.prestamo.modelo.entidad;

public interface CalcularIntereses {

	/**
	 * Calcula porcentaje de intereses
	 * 
	 * @param valor prestamo
	 * @return porcetaje intereses
	 */
	public float clacularPorcentajeInteres();

	/**
	 * Calcula el valor de intereses
	 * 
	 * @param valor prestamo
	 * @return valor intereses
	 */
	public double clacularValorInteres(float porsentajeInteres);

}

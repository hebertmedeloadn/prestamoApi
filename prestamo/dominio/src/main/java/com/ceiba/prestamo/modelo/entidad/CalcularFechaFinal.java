package com.ceiba.prestamo.modelo.entidad;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class CalcularFechaFinal {

	private static final int PLAZO_EN_MESES = 1;
	private static final int DIA_ADICIONAL = 1;

	private Date fechaInicial;

	public CalcularFechaFinal(Date fechaInicial) {
		this.fechaInicial = (Date) fechaInicial.clone();
	}

	public Date calcularFechaFinalPrestamo() {
		LocalDateTime fecha = convertirDateALocalDateTime(fechaInicial);

		fecha = fecha.plusMonths(PLAZO_EN_MESES);

		if (esDomingo(fecha)) {
			fecha = fecha.plusDays(DIA_ADICIONAL);
		}
		return convertirLocalDateTimeADate(fecha);
	}

	public boolean esDomingo(LocalDateTime fecha) {
		DayOfWeek diaSemanaFecha = fecha.getDayOfWeek();
		return DayOfWeek.SATURDAY == diaSemanaFecha;
	}

	public LocalDateTime convertirDateALocalDateTime(Date date) {
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public Date convertirLocalDateTimeADate(LocalDateTime date) {
		return java.sql.Timestamp.valueOf(date);
	}
}

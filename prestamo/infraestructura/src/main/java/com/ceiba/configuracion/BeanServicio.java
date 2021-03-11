package com.ceiba.configuracion;

import com.ceiba.prestamo.modelo.entidad.CalcularFechaFinal;
import com.ceiba.prestamo.modelo.entidad.CalcularIntereses;
import com.ceiba.prestamo.puerto.dao.DaoPrestamo;
import com.ceiba.prestamo.puerto.respositorio.RespositorioPrestamo;
import com.ceiba.prestamo.servicio.ServicioCrearPrestamo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearPrestamo servicioCrearPrestamo(RespositorioPrestamo repositorioPrestamo,
			DaoPrestamo daoPrestamo) {
		return new ServicioCrearPrestamo(repositorioPrestamo, daoPrestamo);
	}

}

package com.ceiba.configuracion;

import com.ceiba.prestamo.modelo.entidad.CalcularIntereses;
import com.ceiba.prestamo.puerto.dao.DaoPrestamo;
import com.ceiba.prestamo.puerto.respositorio.RespositorioPrestamo;
import com.ceiba.prestamo.servicio.ServicioCrearPrestamo;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
    
    @Bean
    public ServicioCrearPrestamo servicioCrearPrestamo(RespositorioPrestamo repositorioPrestamo, DaoPrestamo daoPrestamo) {
        return new ServicioCrearPrestamo(repositorioPrestamo, daoPrestamo);
    }
	

}

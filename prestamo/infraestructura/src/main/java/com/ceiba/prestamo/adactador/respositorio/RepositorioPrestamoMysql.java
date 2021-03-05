package com.ceiba.prestamo.adactador.respositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.respositorio.RespositorioPrestamo;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPrestamoMysql implements RespositorioPrestamo {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "usuario", value = "crear")
	private static String sqlCrear;

	public RepositorioPrestamoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public Long crear(Prestamo prestamo) {
		return this.customNamedParameterJdbcTemplate.crear(prestamo, sqlCrear);
	}
}

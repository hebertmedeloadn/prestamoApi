package com.ceiba.prestamo.adactador.dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.prestamo.modelo.dto.DtoPrestamo;
import com.ceiba.prestamo.puerto.dao.DaoPrestamo;

@Component
public class DaoPrestamoMysql implements DaoPrestamo {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	public DaoPrestamoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@SqlStatement(namespace = "prestamo", value = "listar")
	private static String sqlListar;

	@SqlStatement(namespace = "prestamo", value = "sumarValorPrestamosActivos")
	private static String sqlSumarValorPrestamosActivos;

	@SqlStatement(namespace = "prestamo", value = "contarCreditosActivosPorCliente")
	private static String sqlContarCreditosActivosPorCliente;

	@SqlStatement(namespace = "prestamo", value = "sumarvalorPrestamosActivosCliente")
	private static String sqlSumarValorPrestamosCliente;

	@Override
	public List<DtoPrestamo> listar(Date fecha) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fechaActual", new Date());
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, paramSource,
				new MapeoPrestamo());
	}

	@Override
	public double valorToltalPrestamosActivos(Date fecha) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("fechaActual", fecha);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlSumarValorPrestamosActivos, paramSource, Double.class);
	}

	@Override
	public int contarPrestamosActivosPorCliente(Long documentoCliente, Date fechaActual) {

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("documentoCliente", documentoCliente);
		paramSource.addValue("fechaActual", fechaActual);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlContarCreditosActivosPorCliente, paramSource, Integer.class);
	}

	@Override
	public double valorPrestamosCliente(Long documentoCliente, Date fechaActual) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("documentoCliente", documentoCliente);
		paramSource.addValue("fechaActual", fechaActual);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
				.queryForObject(sqlSumarValorPrestamosCliente, paramSource, Double.class);
	}

}

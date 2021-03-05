package com.ceiba.prestamo.adactador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.prestamo.modelo.dto.DtoPrestamo;

public class MapeoPrestamo implements RowMapper<DtoPrestamo>, MapperResult {

	@Override
	public DtoPrestamo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id");
		Long documentoCliente = resultSet.getLong("documento_cliente");
		double valor = resultSet.getDouble("valor");
		float porcentajeInteres = resultSet.getFloat("valor_interes");
		double valorInteres = resultSet.getDouble("porcentaje_interes");
		double valorApagar = resultSet.getDouble("valor_apagar");
		Date fechaInicial = resultSet.getDate("fecha_inicial");
		Date fechaFinal = resultSet.getDate("fecha_final");		
		
		return new DtoPrestamo(id, documentoCliente, valor, porcentajeInteres, valorInteres, valorApagar, fechaInicial,
				fechaFinal);
	}

}

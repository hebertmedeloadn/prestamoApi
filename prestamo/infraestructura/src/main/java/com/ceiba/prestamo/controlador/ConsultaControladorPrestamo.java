package com.ceiba.prestamo.controlador;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.ceiba.prestamo.consulta.ManejadorListarPrestamos;
import com.ceiba.prestamo.modelo.dto.DtoPrestamo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/prestamos")
@Api(tags = { "Controlador consulta prestamo" })
public class ConsultaControladorPrestamo {

	private final ManejadorListarPrestamos manejadorListarPrestamos;

	public ConsultaControladorPrestamo(ManejadorListarPrestamos manejadorListarPrestamo) {
		this.manejadorListarPrestamos = manejadorListarPrestamo;
	}

	@GetMapping
	@ApiOperation("Listar Prestamos")
	public List<DtoPrestamo> listar() {
		
		try {
			return this.manejadorListarPrestamos.ejecutar();
		} catch (Exception e) {
			System.out.println("prinstacktrace " + e.getStackTrace());
			return null;
		}
		

		
		
	}

}

package com.ceiba.prestamo.comando;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPrestamo {

	private Long documentoCliente;
	private double valor;
	private Date fechaInicial;
}

select    id,  documento_cliente,  valor,  porcentaje_interes,  valor_interes,  valor_apagar,  fecha_inicial,  fecha_final
 from prestamos
 where :fechaActual BETWEEN fecha_inicial AND fecha_final
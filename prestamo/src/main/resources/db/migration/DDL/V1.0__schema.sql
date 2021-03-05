CREATE TABLE prestamo.prestamos (
  id INT NOT NULL auto_increment,
  documento_cliente INT NOT NULL,
  valor DOUBLE NOT NULL,
  porcentaje_interes FLOAT NOT NULL,
  valor_interes DOUBLE NOT NULL,
  valor_apagar DOUBLE NOT NULL,
  fecha_inicial DATE NOT NULL,
  fecha_final DATE NOT NULL,
  PRIMARY KEY (id)
  );
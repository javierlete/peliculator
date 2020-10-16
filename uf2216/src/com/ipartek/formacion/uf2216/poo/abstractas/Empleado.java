package com.ipartek.formacion.uf2216.poo.abstractas;

import java.math.BigDecimal;

public abstract class Empleado {
	private Long id;
	private String nombre;
	
	public Empleado(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public abstract BigDecimal getSueldoMensual();
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + "]";
	}
}

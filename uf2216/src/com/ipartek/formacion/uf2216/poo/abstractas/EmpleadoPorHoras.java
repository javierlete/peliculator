package com.ipartek.formacion.uf2216.poo.abstractas;

import java.math.BigDecimal;

public class EmpleadoPorHoras extends Empleado {

	private BigDecimal sueldoPorHora;
	private Integer numeroHoras;
	
	public EmpleadoPorHoras(Long id, String nombre, BigDecimal sueldoPorHora, Integer numeroHoras) {
		super(id, nombre);
		this.sueldoPorHora = sueldoPorHora;
		this.numeroHoras = numeroHoras;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoPorHora.multiply(new BigDecimal(numeroHoras));
	}

	@Override
	public String toString() {
		return "EmpleadoPorHoras [sueldoPorHora=" + sueldoPorHora + ", numeroHoras=" + numeroHoras + ", toString()="
				+ super.toString() + "]";
	}
}

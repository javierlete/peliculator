package com.ipartek.formacion.uf2216.poo.abstractas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EmpleadoIndefinido extends Empleado {

	private BigDecimal sueldoAnual;
	private Integer pagas;

	public EmpleadoIndefinido(Long id, String nombre, BigDecimal sueldoAnual, Integer pagas) {
		super(id, nombre);
		this.sueldoAnual = sueldoAnual;
		this.pagas = pagas;
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(pagas), 2, RoundingMode.HALF_UP);
	}

	@Override
	public String toString() {
		return "EmpleadoIndefinido [sueldoAnual=" + sueldoAnual + ", pagas=" + pagas + ", toString()="
				+ super.toString() + "]";
	}
}

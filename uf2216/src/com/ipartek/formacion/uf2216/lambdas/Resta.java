package com.ipartek.formacion.uf2216.lambdas;

public class Resta implements Operacion {
	@Override
	public double ejecutar(double op1, double op2) {
		return op1 - op2;
	}
}

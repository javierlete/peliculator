package com.ipartek.formacion.uf2216.lambdas;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

	public static void main(String[] args) {
		mostrarResultado(5, (x, y) -> x - y, 6);

		List<String> al = new ArrayList<>();

		al.add("Uno");
		al.add("Dos");
		al.add("Uno");
		al.add("Tres");

		final StringBuffer sb1 = new StringBuffer();
		
		for(String dato: al) {
			sb1.append(dato);
		}
		
		System.out.println(sb1);
				
		final StringBuffer sb2= new StringBuffer(); 

		al.forEach(dato -> sb2.append(dato));

		System.out.println(sb2);
		
		al.forEach(dato -> System.out.println("Dos".equals(dato) ? "ENCONTRADO" : "No encontrado"));
		
		al.removeIf(dato -> "Dos".equals(dato));
		
		al.forEach(dato -> System.out.println(dato));
	}

	public static void mainCompleto(String[] args) {

		double a = 5.2;
		Operacion operacion = new Suma();
		double b = 1.2;

		mostrarResultado(a, operacion, b);

		operacion = new Resta();

		mostrarResultado(a, operacion, b);

		mostrarResultado(a, new Multiplicacion(), b);

		// Clase anonima que implementa el interface Operacion
		mostrarResultado(a, new Operacion() {
			@Override
			public double ejecutar(double op1, double op2) {
				return op1 / op2;
			}
		}, b);

		mostrarResultado(a, (op1, op2) -> op1 / op2, b);

		mostrarResultado(a, (op1, op2) -> {
			System.out.println("Dentro del lambda");
			return op1 / op2;
		}, b);
	}

	private static void mostrarResultado(double a, Operacion operacion, double b) {
		System.out.println(operacion.ejecutar(a, b));
	}

	// Clase interna
	private static class Multiplicacion implements Operacion {
		@Override
		public double ejecutar(double op1, double op2) {
			return op1 * op2;
		}
	}
}

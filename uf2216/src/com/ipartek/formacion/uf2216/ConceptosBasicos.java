package com.ipartek.formacion.uf2216;

import java.util.Scanner;

public class ConceptosBasicos {

	/**
	 * Comentario de javadoc
	 * 
	 * @param args argumentos recibidos por consola
	 */
	public static void main(String[] args) {
		/*
		 * Comentario multilínea
		 */

		// Comentario de línea

		// Tipos de datos

		int i = 0;

		System.out.println(i);

		double multiplicacion, suma, d1 = 0.1, d2 = 0.2;

		suma = d1 + d2;

		multiplicacion = suma * 0.1 * 0.2 * 10000000000000.0;

		System.out.println(suma);

		System.out.println(multiplicacion);

		boolean b = true;

		System.out.println(b);

		char c = 'a';

		c = '\n';

		System.out.println(c);

		String nombre;

		nombre = "Javier";

		System.out.println(nombre);

		nombre = nombre + " Lete";

		System.out.println(nombre);

		String fichero = "C:\\nuevos\\trabajos.txt";

		System.out.println(fichero);

		// Operadores

		System.out.println(5 ^ 2); // 5 XOR 2 --> 101 XOR 010 = 111

		System.out.println(5 % 2); // Resto de 5 entre 2

		int x = 3;

		System.out.println(x == 5);

		System.out.println(1 + x + 10);

		System.out.println(1 <= x && x <= 10);

		x = 5;

		System.out.println(x++);
		System.out.println(x);

		x = 5;

		System.out.println(++x);
		System.out.println(x);

		boolean y;

		// Ejemplo de expresión que normalmente no se escribe, pero es válida ñalskdjf
		// ñlaksdhg ñlkjasd ñflkh asdñlgjk añsldkfh ñlasdkj gñlha sdlkñgh asdlñkg
		System.out.println(y = (x += 10 * x++) > 10);

		System.out.println(y);

		byte bits = 5;

		System.out.println(~bits);

		System.out.println(-20 >> 2);

		System.out.println(-20 >>> 2);

		int n1, n2;

		n1 = 8;
		n2 = 7;

		System.out.println(n1 > n2 ? n1 : n2);

		System.out.println(b ? "Verdadero" : "Falso");

		// Sentencias de control

		boolean estaEncendido = true;

		System.out.println(estaEncendido);

		// b == true ---> b ######## b != true ---> !b
		if (estaEncendido) {
			System.out.println("Está encendido");
		} else {
			System.out.println("No está encendido");
			System.out.println("Habrá que arrancarlo");
		}

		System.out.println(estaEncendido);

		System.out.print("Dime la opción: ");

		// Scanner --> Clase que existe desde Java 5
		@SuppressWarnings("resource")
		String opcion = new Scanner(System.in).nextLine();

		if ("primera".equals(opcion)) { // if (opcion != null && opcion.equals("primera") )
			System.out.println("Primera");
		} else if ("segunda".equals(opcion)) {
			System.out.println("Segunda");
		} else {
			System.out.println("Opción desconocida");
		}

		// A partir de Java 7 se puede hacer switch con String
		switch (opcion) {
		case "primera":
			System.out.println("Primera");
			break;
		case "segunda":
			System.out.println("Segunda");
			break;
		default:
			System.out.println("Opción desconocida");
		}

		int mes = 6, dias;

		switch (mes) {
		case 2:
			dias = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dias = 30;
			break;
		default:
			dias = 31;
		}

		System.out.println("El mes " + mes + " tiene " + dias + " días");

		// TODO Sentencias de control
		// TODO Arrays
		// TODO Colecciones
		// TODO StringBuffer
	}

}

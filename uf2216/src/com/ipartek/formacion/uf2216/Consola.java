package com.ipartek.formacion.uf2216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Consola {
	public static void main(String[] args) {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("Introduce tu nombre: ");

			String nombre = br.readLine();

			System.out.println("Hola " + nombre);
		} catch (IOException e) {
			System.out.println("No se ha podido acceder a la consola");
		} finally {
//			try {
//				if(br != null) {
//					br.close();
//					br = null;
//				}
//			} catch (IOException e) {
//				System.out.println("Ha habido un problema en el cierre");
//			}
		}

		// Java 5 (Scanner) Java 7 (try with resources)
		try (Scanner s = new Scanner(System.in)) {

			System.out.print("Introduce tu apellido: ");

			String apellido = s.nextLine();

			System.out.println("Hola " + apellido);

			// El finally viene implícito con close para el recurso del Scanner.
		} /* finally {
			s.close();
		} */

		// Java 6

		if (System.console() != null) {

			System.out.print("Dame el dato: ");

			String dato = System.console().readLine(); // Da NullPointerException en Eclipse, pero funciona en una
														// consola real
			System.out.println("El dato es : " + dato);
		}
	}
}

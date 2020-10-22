package com.ipartek.formacion.uf2216.bibliotecas;

public class Consola {
	public  static final boolean SIN_ENTER = false;
	
//	private static Scanner s = new Scanner(System.in);
	
	// TODO Continuar con todos los metodos de consola
//	public static Long pedirNumero(String mensaje) {
//		p(mensaje, SIN_ENTER);
//		Long id = s.nextLong();
//		s.nextLine();
//	}
	
	public static void p(Object objeto, boolean conEnter) {
		if (conEnter) {
			p(objeto);
		} else {
			System.out.print(objeto);
		}
	}

	public static void p(Object objeto) {
		System.out.println(objeto);
	}

	public static void p() {
		System.out.println();
	}
}

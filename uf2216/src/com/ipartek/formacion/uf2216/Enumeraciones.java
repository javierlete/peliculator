package com.ipartek.formacion.uf2216;

public class Enumeraciones {
	public static final int MINIMIZAR = 1, MAXIMIZAR = 2, CERRAR = 3;
	
	//https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
	public enum Estados { MINIMIZADO, MAXIMIZADO, CERRADO }
	
	public static void main(String[] args) {
		int boton = MINIMIZAR;
		boton = 10;
		
		System.out.println(boton);
		
		Estados estado = Estados.MINIMIZADO;
		
		switch(estado) {
		case MINIMIZADO:
			System.out.println("Minimizado");
			System.out.println(estado);
			break;
		case MAXIMIZADO:
			System.out.println("Maximizado");
			break;
		case CERRADO:
			System.out.println("Cerrado");
			break;
		default:
			System.out.println("Ni idea");
		}
		
		
	}
}

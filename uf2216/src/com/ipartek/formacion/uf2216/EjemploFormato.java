package com.ipartek.formacion.uf2216;

import java.util.Date;

import com.ipartek.formacion.uf2216.poo.Usuario;

public class EjemploFormato {

	// https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax
	// %[argument_index$][flags][width][.precision]conversion
	public static void main(String[] args) {
		String texto = "Hola";
		double numero = 12345.564323;
		System.out.printf("%s, numero vale %s\n", texto, numero);
		
		String resultado = String.format("%s, numero vale %,20.2f", texto, numero);
		
		System.out.println(resultado);
		
		System.out.println(new Prueba());
		
		System.out.println(new Usuario(1L, "asd@gg.d", "slkfjlsd"));
		
		System.out.println(String.format("%1$d, %1$h, %1$o, %1$x, %2$e, %3$f", 255, 123412340000000d, numero));
	
		System.out.println(String.format("Este artículo tiene un %d%% de IVA", 21));
		
		System.out.println(String.format("%1$td de %1$tB de %1$tY, a las %1$tH horas, %1$tM minutos y %1$tS segundos %1$tF %1$tT", new Date()));
		
		System.out.println(String.format("%1$+,d %1$d", 250000000));
		
		System.out.println(String.format("%10s | %,20.2f", "Corta", 123412343.1234123423));
		System.out.println(String.format("%10s | %,20.2f", "Mega larga", 12343.1234123423563453));
		
	}
	
	public static class Prueba {}

}

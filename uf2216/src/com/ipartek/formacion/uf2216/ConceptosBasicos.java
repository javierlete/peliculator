package com.ipartek.formacion.uf2216;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class ConceptosBasicos {

	/**
	 * Comentario de javadoc
	 * 
	 * @param args argumentos recibidos por consola
	 */
	@SuppressWarnings({ "deprecation", "resource" })
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

		System.out.println(suma);

		BigDecimal bd1 = new BigDecimal("0.1");
		BigDecimal bd2 = new BigDecimal("0.2");

		BigDecimal sumaBigDecimal = bd1.add(bd2);

		System.out.println(sumaBigDecimal);

		multiplicacion = suma * 0.1 * 0.2 * 10000000000000.0;

		System.out.println(multiplicacion);

		int aleatorio = (int) (Math.random() * 10) + 1;

		System.out.println("Aleatorio entre 1 y 10: " + aleatorio);

		// long l = 9923456123456123456L;

		BigInteger bi = new BigInteger("9923456123456123456");

		System.out.println(bi.add(new BigInteger("2")));

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

		System.out.println(Math.sqrt(4));

		// Java 1.4

		Integer objetoInteger;

		objetoInteger = new Integer(5);

		int primitivoInteger = objetoInteger.intValue();

		System.out.println(primitivoInteger);

		// Java 5 (AutoBoxing)

		objetoInteger = 5;
		primitivoInteger = objetoInteger;

		objetoInteger = null;
		primitivoInteger = objetoInteger == null ? 0 : objetoInteger;

		System.out.println("Primitivo: " + primitivoInteger);

		Integer oi1 = 5, oi2 = 5;

		System.out.println(oi1 + oi2);

		System.out.println("oi1 y oi2 son iguales: " + (oi1 == oi2));

		// Forma incorrecta de acumular información en una cadena

		String log = "";

		log += new Date() + ": " + "Se ha hecho el proceso..." + '\n'; // el log anterior se desecha y se sustituye por
																		// el texto nuevo que incluye el anterior
		log += new Date() + ": " + "Error al conectar..." + '\n';
		// log = new StringBuffer(log).append(new Date()).append(": ").append("Error al
		// conectar...").append('\n').toString();

		System.out.println(log);

		// Forma correcta de acumular información en una cadena

		StringBuffer logNuevo = new StringBuffer();

		logNuevo.append(new Date()).append(": ").append("Se ha hecho el proceso...").append('\n');
		logNuevo.append(new Date()).append(": ").append("Error al conectar...").append('\n');

		System.out.println(logNuevo);

		// FECHAS

		// Java 1.0
		Date date = new Date();

		System.out.println(date);

		System.out.println(date.getYear());

		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime()));

		// Java 1.1
		Calendar calendar = GregorianCalendar.getInstance();

		System.out.println(calendar.get(Calendar.YEAR));

		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));

		// Java 8
		LocalDateTime hoy = LocalDateTime.now();

		System.out.println(hoy.getYear());

		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");

		System.out.println(hoy.format(formatoFecha));

		// Arrays / "Arreglos" / Matrices

		int[] arr = new int[2];

		arr[0] = 5;
		arr[1] = 7;
		// arr[2] = 10; // Exception in thread "main"
		// java.lang.ArrayIndexOutOfBoundsException: 2

		System.out.println(arr.length);

		String[][] agenda = new String[366][24];

		agenda[200][15] = "Curso de Java IFCD0211";
		agenda[201][15] = agenda[200][15];

		System.out.println(agenda.length);
		System.out.println(agenda[200].length);

		String[][] cuadranteAnual = new String[12][];

		cuadranteAnual[0] = new String[31];
		cuadranteAnual[1] = new String[28];

		// Colecciones (los <String> aparecen en Java 5)

		System.out.println("ARRAYLIST");

		ArrayList<String> al = new ArrayList<>(); // <> aparece en Java 8

		al.add("Uno");
		al.add("Dos");
		al.add("Tres");

		System.out.println(al.get(1));

		al.remove(1);

		System.out.println(al.get(1));

		System.out.println(al.size());

		TreeMap<String, String> diccionario = new TreeMap<>();

		diccionario.put("Casa", "House");
		diccionario.put("Ala", "Wing");

		System.out.println(diccionario.get("Ala"));

		System.out.println(diccionario.ceilingEntry("Ala"));

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

		// Sentencias de control

		// Alternativas

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

		// Repetitivas

		int contador = 0;

		while (contador < 5) {
			System.out.println(++contador);
		}

		String repetir;

		do {
			System.out.print("¿Quieres repetir? ");
			repetir = new Scanner(System.in).nextLine();
		} while ("s".equals(repetir));

		for (int cont = 1; cont <= 10; cont++) {
			System.out.println(cont);
		}

//		int cont = 1;
//		while (cont <= 10) {
//			System.out.println(cont);
//			cont++;
//		}
		
		for(int indice = 0; indice < arr.length; indice++) {
			System.out.println(arr[indice]);
		}
		
		for(int indice = 0; indice < al.size(); indice++) {
			System.out.println(al.get(indice));
		}
		
		Iterator<String> iterador = diccionario.keySet().iterator();
		
		String key;
		while(iterador.hasNext()) {
			key = iterador.next();
			
			System.out.println(key + ": " + diccionario.get(key));
		}
		
		// Java 5
		for(int dato: arr) {
			System.out.println(dato);
		}
		
		for(String dato: al) {
			System.out.println(dato);
		}
		
		for(String clave: diccionario.keySet()) {
			System.out.println(clave + ": " + diccionario.get(clave));
		}
	}

}

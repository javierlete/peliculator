package com.ipartek.formacion.uf2216.genericos;

import java.math.BigInteger;

public class PuntoPrueba {

	public static void main(String[] args) {
		Punto<String, BigInteger> punto = new Punto<>("A", new BigInteger("1"));
		
		System.out.println(punto);
		
		String x = punto.getX();
		BigInteger y = punto.getY();
		
		System.out.println(x + ", " + y);
		
		Punto<Integer, Integer> p = new Punto<>(5, 6);
		
		p.setX(4);
		
		System.out.println(p);
	}

}

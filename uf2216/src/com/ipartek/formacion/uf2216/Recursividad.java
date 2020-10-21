package com.ipartek.formacion.uf2216;

import java.math.BigInteger;

public class Recursividad {

	public static void main(String[] args) {
		System.out.println(factorial(new BigInteger("10000")));
	}
	
	private static BigInteger factorial(BigInteger numero) { // 5! = 5 * 4 * 3 * 2 * 1 = 5 * 4! = 20 * 3! = 60 * 2! = 120 * 1! = 120
		if(numero.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		}
		
		return numero.multiply(factorial(numero.subtract(BigInteger.ONE)));
	}
}

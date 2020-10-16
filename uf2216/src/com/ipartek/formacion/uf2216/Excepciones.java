package com.ipartek.formacion.uf2216;

public class Excepciones {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		int div = 0;

		try {
			String s = null;

			System.out.println(s.toUpperCase());

			int[] arr = new int[2];

			arr[1] = 45;
			arr[2] = 23;

			int a, b;

			a = 40;
			b = 6;

			div = a / b;
		} catch (ArithmeticException e) {
			System.out.println("Ha habido un error en la operación aritmética");
			div = Integer.MAX_VALUE;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Te has salido del array");
		} catch (Exception e) {
			System.out.println("No sé que ha pasado. Ha fallado la aplicación. Me voy.");
			//System.exit(1);
			return;
		} finally {
			System.out.println("Me ejecuto SIEMPRE");
		}

		System.out.println(div);

		System.out.println("FIN");
	}

}

package com.ipartek.formacion.uf2216.threads;

public class Carrera {

	public static void main(String[] args) {
//		Corredor c1 = new Corredor("UNO");
//		Corredor c2 = new Corredor("DOS");
//		
//		c1.correr();
//		c2.correr();
		
		Corredor c1 = new Corredor("UNO");
		Corredor c2 = new Corredor("DOS");
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.start();
		t2.start();
		
		pausa(1000);
		
		c1.suspender();
		
		pausa(1000);
		
		c1.continuar();
		
		pausa(1000);
		
		c2.parar();
		
	}

	private static void pausa(long milis) {
		try { Thread.sleep(milis); } catch (InterruptedException e) {}
	}

}

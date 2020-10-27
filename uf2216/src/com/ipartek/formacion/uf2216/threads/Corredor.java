package com.ipartek.formacion.uf2216.threads;

public class Corredor implements Runnable {
	private String dorsal;
	private int posicion;
	private boolean suspendido, parado;
	
	public Corredor(String dorsal) {
		this.dorsal = dorsal;
	}
	
	public void correr() {
		for(posicion = 1; posicion <= 10 && !parado; posicion++) {
			
			do {
				try {
					Thread.sleep((long) (Math.random() * 1000));
				} catch (InterruptedException e) {
					// No hacemos nada, ya que el propósito es que se interrumpa la aplicación durante 1 segundo
					// No queremos notificar a nadie
				} 
			} while (suspendido);
			
			System.out.printf("%5s %5d%n", dorsal, posicion);
		}
	}

	public void suspender() {
		suspendido = true;
	}
	
	public void parar() {
		parado = true;
	}
	
	public void continuar() {
		suspendido = false;
	}
	
	@Override
	public void run() {
		correr();
	}
}

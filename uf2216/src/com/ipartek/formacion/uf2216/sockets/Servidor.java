package com.ipartek.formacion.uf2216.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		System.out.println("Arrancando servidor");
		
		try (ServerSocket ss = new ServerSocket(1234);
				Socket s = ss.accept();
				PrintWriter out = new PrintWriter(s.getOutputStream(), AUTO_FLUSH);
				//BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				 Scanner in = new Scanner(s.getInputStream())) {
			System.out.println("Recibido un cliente");
			
			out.println("BIENVENIDO AL SERVIDOR MAYUSCULADOR");
			
			String texto = in.nextLine();
			
			System.out.println("Se ha recibido el texto " + texto);
			
			out.println(texto.toUpperCase());
		} catch (IOException e) {
			System.out.println("Error de lectura/escritura");
		}
	}
	
}

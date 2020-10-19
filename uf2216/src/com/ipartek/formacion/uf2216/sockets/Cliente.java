package com.ipartek.formacion.uf2216.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		try (Socket s = new Socket("localhost", 1234);
				PrintWriter out = new PrintWriter(s.getOutputStream(), AUTO_FLUSH);
				//BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				 Scanner in = new Scanner(s.getInputStream())) {
			String texto = in.nextLine();
			
			System.out.println(texto);
			
			out.println("Javier");
			
			texto = in.nextLine();
			
			System.out.println(texto);
		} catch (UnknownHostException e) {
			System.out.println("No se ha encontrado el servidor");
		} catch (IOException e) {
			System.out.println("Error de lectura/escritura");
		}
	}
}

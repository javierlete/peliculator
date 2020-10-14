package com.ipartek.formacion.uf2216.poopruebas;

import com.ipartek.formacion.uf2216.poo.Usuario;

public class UsuarioPruebas {

	public static void main(String[] args) {
		Usuario usuario; // Vale null
		
		usuario = new Usuario(1L, "javier@email.net", "micontraseña"); // Constructor por defecto
		
		System.out.println(usuario.getId());
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getPassword());
		
		usuario = new Usuario();
		
		usuario.setId(5);
		usuario.setEmail("sdfg@fdg.dfgh");
		usuario.setPassword("prueba");
		
		System.out.println("[" + usuario.getEmail() + "]");
		
		System.out.println(usuario.getPassword());
		System.out.println(usuario.getPassword('x'));
		
		usuario = null;
		
		// Llamada al Garbage Collector explícita: NO se suele hacer
		System.gc();
	}
}

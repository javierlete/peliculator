package com.ipartek.formacion.uf2216.poopruebas;

import com.ipartek.formacion.uf2216.poo.Departamento;
import com.ipartek.formacion.uf2216.poo.Usuario;
import com.ipartek.formacion.uf2216.poo.UsuarioExtendido;

public class UsuarioExtendidoPruebas {
	public static void main(String[] args) {
		UsuarioExtendido ue;

		ue = new UsuarioExtendido();

		System.out.println(ue.getEmail());

		ue.setEmail("miemail@email.email");

		System.out.println(ue.getEmail());

		ue.setDireccion("Mi casa");
		ue.setTelefono("Teléfonooooo");

		System.out.println(ue.getDireccion());
		System.out.println(ue.getTelefono());

		System.out.println(ue.convertirATexto());

		Usuario usuario = new Usuario("pepe@pepe.pepe", "Contra");

		System.out.println(usuario.convertirATexto());

		Usuario u = ue;

		// u.getDireccion();
		// No se puede porque solo puede acceder a los métodos
		// declarados en Usuario (que es el tipo con el que está declarada la variable
		// u)

		UsuarioExtendido ue2 = (UsuarioExtendido) u;

		System.out.println("DIRECCIÓN: " + ue2.getDireccion());

		if(u instanceof UsuarioExtendido) {
			UsuarioExtendido ue3 = (UsuarioExtendido) u; // ClassCastException si instanceof da false
			System.out.println(ue3.convertirATexto());
		}
		
		// Usuario u2 = (Usuario)new Departamento(1L, "Prueba"); // Error de compilación
		
		Departamento d = new Departamento(1L, "Pruebas");
		
		d.contratar(usuario);
		d.contratar(ue);
		
		for(Usuario usuarioDepartamento: d.getUsuarios()) {
			System.out.println(usuarioDepartamento.convertirATexto());
		}
	}
}

package com.ipartek.formacion.uf2216.poopruebas;

import java.lang.reflect.InvocationTargetException;

import com.ipartek.formacion.uf2216.poo.Departamento;
import com.ipartek.formacion.uf2216.poo.Usuario;
import com.ipartek.formacion.uf2216.poo.UsuarioExtendido;

public class UsuarioExtendidoPruebas {
	@SuppressWarnings("unused")
	private static int estatica; // En VB.NET Shared
	@SuppressWarnings("unused")
	private int noEstatica;

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		// java UsuarioExtendidoPruebas 1 2 3
		// JVM hace lo siguiente:
		// UsuarioExtendidoPruebas.main(new String[] {"1", "2", "3"});

		estatica = 3;
		UsuarioExtendidoPruebas.estatica = 5;

		UsuarioExtendidoPruebas uep = new UsuarioExtendidoPruebas();
		uep.noEstatica = 10;

		// uep.estatica = 20; // Funciona pero no es recomendable
		// Siempre utiliza la misma zona de memoria

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

		if (u instanceof UsuarioExtendido) {
			UsuarioExtendido ue3 = (UsuarioExtendido) u; // ClassCastException si instanceof da false
			System.out.println(ue3.convertirATexto());
		}

		// Usuario u2 = (Usuario)new Departamento(1L, "Prueba"); // Error de compilación

		Departamento d = new Departamento(1L, "Pruebas");

		d.contratar(usuario);
		d.contratar(ue);

		for (Usuario usuarioDepartamento : d.getUsuarios()) {
			System.out.println(usuarioDepartamento.convertirATexto());
		}

		ue.setId(8L);

		System.out.println(ue instanceof Object);
		System.out.println(ue.getId());
		System.out.println(ue.getId() instanceof Object);

		@SuppressWarnings("unused")
		Object o = ue;

		o = new Object();
		
		System.out.println(u.getClass().getName()); //.getMethods()[3].invoke(u, new Object[] {}));
		u.setId(5L);
		System.out.println(u.hashCode());
		u.setId(6L);
		System.out.println(u.hashCode());
		
		System.out.println(u.toString());
		
		Usuario usu1 = new Usuario();
		Usuario usu2 = new Usuario();
		
		System.out.println(usu1.equals(usu2));
		
		System.out.println(Usuario.getContador());
		
		@SuppressWarnings("unused")
		Usuario u5 = new Usuario(1L, "usuario@b.c", "contra");
		UsuarioExtendido ue5 = new UsuarioExtendido(2L, "usuario@extendido.a", "alksdj");
		
		System.out.println("PRUEBAS DE CONTADOR");
		
		System.out.println(Usuario.getContador());
		
		System.out.println(new Usuario(null, "usuario@huerfano.es", "hala"));
		
		System.out.println(Usuario.getContador());
		
		u5 = ue5;
		ue5 = null;
		u5 = null;
		
		System.gc();
		
		System.out.println(Usuario.getContador());
	}
}

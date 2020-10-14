package com.ipartek.formacion.uf2216.poopruebas;

import com.ipartek.formacion.uf2216.poo.Departamento;
import com.ipartek.formacion.uf2216.poo.Usuario;

public class DepartamentoPruebas {

	public static void main(String[] args) {
		Departamento departamento = new Departamento(null, "Informática");
		
		departamento.contratar(new Usuario("javier@a.b", "Lete"));
		
		//departamento.getUsuarios().add(null);
		
		departamento.getUsuarios().get(0).setEmail("a@que.jode");
		
		departamento.contratar(new Usuario("pepe@c.d", "Pérez"));
		
		for(Usuario usuario: departamento.getUsuarios()) {
			System.out.println(usuario.getEmail());
		}
	}

}

package com.ipartek.formacion.uf2216;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.ipartek.formacion.uf2216.poo.Departamento;
import com.ipartek.formacion.uf2216.poo.Usuario;
import com.ipartek.formacion.uf2216.poo.UsuarioExtendido;

public class SerializacionGuardarObjetos {

	public static void main(String[] args) {
		Departamento departamento = new Departamento(1L, "Informatica");
		
		departamento.contratar(new Usuario(1L, "javier@ipartek.com", "contra"));
		departamento.contratar(new UsuarioExtendido(2L, "completo@ipartek.com", "contraseña", "Su casa", "941231234"));
		
		try (FileOutputStream fos = new FileOutputStream("objetos.jlg");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(departamento);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Ha habido un error al escribir el objeto");
		}		
		
		System.out.println(departamento instanceof Serializable);
	}
}

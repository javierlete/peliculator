package com.ipartek.formacion.uf2216;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;

import com.ipartek.formacion.uf2216.poo.Departamento;
import com.ipartek.formacion.uf2216.poo.Usuario;

public class SerializacionCargarObjetos {

	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("objetos.jlg");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			Departamento departamento = (Departamento) ois.readObject();
			
			System.out.println(departamento.getUsuarios().get(1).convertirATexto());
			
			System.out.println(departamento.getNombre());
			
			for(Usuario usuario : departamento.getUsuarios()) {
				System.out.println(usuario);
			}
			
			Iterator<Usuario> iterador = departamento.getUsuarios().iterator();
			
			Usuario usuario;
			
			while(iterador.hasNext()) {
				usuario = iterador.next();
				System.out.println(usuario);
			}
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("No se ha podido recuperar la informacion");
			e.printStackTrace();
		}
	}
}

package com.ipartek.formacion.uf2216.ejemplodao.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.uf2216.ejemplodao.modelos.Suscriptor;

public class SuscriptorTreeMapDAO {
	private static TreeMap<Long, Suscriptor> suscriptores = new TreeMap<>();
	
	static {
		//DATOS DE PRUEBA
		suscriptores.put(1L, new Suscriptor(1L, "Pepe", "Perez"));
		suscriptores.put(2L, new Suscriptor(2L, "Javier", "Lete"));
	}
	
	public static Iterable<Suscriptor> obtenerTodos() {
		return suscriptores.values();
	}
	
	public static Suscriptor obtenerPorId(Long id) {
		return suscriptores.get(id);
	}
	
	public static void insertar(Suscriptor suscriptor) {
		suscriptores.put(suscriptor.getId(), suscriptor);
	}
	
	public static void modificar(Suscriptor suscriptor) {
		suscriptores.put(suscriptor.getId(), suscriptor);
	}
	
	public static void borrar(Long id) {
		suscriptores.remove(id);
	}
}

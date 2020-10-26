package com.ipartek.formacion.uf2216.ejemplodao.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.uf2216.ejemplodao.entidades.Suscriptor;

public class SuscriptorTreeMapDAO {
	private SuscriptorTreeMapDAO() {}
	
	static TreeMap<Long, Suscriptor> suscriptores = new TreeMap<>();
	
//	static {
//		//DATOS DE PRUEBA
//		suscriptores.put(1L, new Suscriptor(1L, "Pepe", "Perez"));
//		suscriptores.put(2L, new Suscriptor(2L, "Javier", "Lete"));
//	}
	
	public static Iterable<Suscriptor> obtenerTodos() {
		return suscriptores.values();
	}
	
	public static Suscriptor obtenerPorId(Long id) {
		return suscriptores.get(id);
	}
	
	public static void insertar(Suscriptor suscriptor) {
		if(suscriptores.containsKey(suscriptor.getId())) {
			throw new InsertarException("Ese id ya esta en uso");
		}
		
		suscriptores.put(suscriptor.getId(), suscriptor);
	}
	
	public static void modificar(Suscriptor suscriptor) {
		if(!suscriptores.containsKey(suscriptor.getId())) {
			throw new ModificarException("No existe ese id");
		}
		
		suscriptores.put(suscriptor.getId(), suscriptor);
	}
	
	public static void borrar(Long id) {
		if(!suscriptores.containsKey(id)) {
			throw new BorrarException("No existe ese id");
		}
		
		suscriptores.remove(id);
	}
}

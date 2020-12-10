package com.ipartek.formacion.uf2218.crud.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.uf2218.crud.modelos.Genero;

public class GenerosDaoTreeMap implements Dao<Genero> {

	private static final TreeMap<Long, Genero> GENEROS = new TreeMap<>();
	
	static {
		GENEROS.put(1L, new Genero(1L, "Acción", "Se mueven"));
		GENEROS.put(2L, new Genero(2L, "Comedia", "Hacen risas"));
	}
	
	//SINGLETON
	private GenerosDaoTreeMap() {}
	
	private static final GenerosDaoTreeMap INSTANCIA = new GenerosDaoTreeMap();
	
	public static GenerosDaoTreeMap getInstancia() {
		return INSTANCIA;
	}
	//FIN SINGLETON
	
	@Override
	public Iterable<Genero> obtenerTodos() {
		return GENEROS.values();
	}

	@Override
	public Genero obtenerPorId(Long id) {
		return GENEROS.get(id);
	}
}

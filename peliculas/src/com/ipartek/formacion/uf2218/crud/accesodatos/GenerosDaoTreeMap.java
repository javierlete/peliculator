package com.ipartek.formacion.uf2218.crud.accesodatos;

import java.util.ArrayList;
import java.util.TreeMap;

import com.ipartek.formacion.uf2218.crud.modelos.Genero;

public class GenerosDaoTreeMap implements Dao<Genero> {

	private static final TreeMap<Long, Genero> GENEROS = new TreeMap<>();

	static {
		GENEROS.put(1L, new Genero(1L, "Acción", "Se mueven"));
		GENEROS.put(2L, new Genero(2L, "Comedia", "Hacen risas"));
		GENEROS.put(5L, new Genero(5L, "Comic", "Basada en comic"));
		GENEROS.put(6L, new Genero(6L, "SubGenero6", "SubGenero6 descripción"));
		GENEROS.put(7L, new Genero(7L, "SITCOM", ""));
		GENEROS.put(8L, new Genero(8L, "Fácil", "Caca, culo, pedo, pis"));

		ArrayList<Genero> subGeneros1 = new ArrayList<>();
		subGeneros1.add(GENEROS.get(5L));
		subGeneros1.add(GENEROS.get(6L));

		GENEROS.get(1L).setSubGeneros(subGeneros1);

		ArrayList<Genero> subGeneros2 = new ArrayList<>();
		subGeneros2.add(GENEROS.get(7L));
		subGeneros2.add(GENEROS.get(8L));

		GENEROS.get(2L).setSubGeneros(subGeneros2);
	}

	// SINGLETON
	private GenerosDaoTreeMap() {
	}

	private static final GenerosDaoTreeMap INSTANCIA = new GenerosDaoTreeMap();

	public static GenerosDaoTreeMap getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Genero> obtenerTodos() {
		ArrayList<Genero> padres = new ArrayList<>();
		
		for(Genero genero: GENEROS.values()) {
			if(genero.getSubGeneros() != null) {
				padres.add(genero);
			}
		}
		
		return padres;
	}

	@Override
	public Genero obtenerPorId(Long id) {
		return GENEROS.get(id);
	}
}

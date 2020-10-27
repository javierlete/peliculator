package com.ipartek.formacion.uf2216.peliculas.accesodatos;

import java.util.TreeMap;

import com.ipartek.formacion.uf2216.peliculas.entidades.Pelicula;

public class PeliculasDAO {
	private TreeMap<Long, Pelicula> peliculas = new TreeMap<>();

	public Iterable<Pelicula> obtenerTodas() {
		return peliculas.values();
	}

	public Pelicula obtenerPorId(Long id) {
		return peliculas.get(id);
	}
	
	public void insertar(Pelicula pelicula) {
		Long id = peliculas.lastKey() + 1;
		pelicula.setId(id);
		peliculas.put(pelicula.getId(), pelicula);
	}

	public void modificar(Pelicula pelicula) {
		if(!peliculas.containsKey(pelicula.getId())) {
			throw new AccesoDatosException("No existe ese id");
		}
		peliculas.put(pelicula.getId(), pelicula);
	}

	public void borrar(Long id) {
		if(!peliculas.containsKey(id)) {
			throw new AccesoDatosException("No existe ese id");
		}
		peliculas.remove(id);
	}
}

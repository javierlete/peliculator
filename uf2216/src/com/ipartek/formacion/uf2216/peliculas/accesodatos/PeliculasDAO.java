package com.ipartek.formacion.uf2216.peliculas.accesodatos;

import java.time.LocalDate;
import java.util.TreeMap;

import com.ipartek.formacion.uf2216.peliculas.entidades.Pelicula;

public class PeliculasDAO {
	private PeliculasDAO() {}
	
	private static TreeMap<Long, Pelicula> peliculas = new TreeMap<>();

	static {
		peliculas.put(1L, new Pelicula(1L, "Indiana Jones", "Accion", LocalDate.of(1980, 6, 5)));
		peliculas.put(2L, new Pelicula(2L, "Superman", "Accion", LocalDate.of(1983, 1, 2)));
	}
	
	public static Iterable<Pelicula> obtenerTodas() {
		return peliculas.values();
	}

	public static Pelicula obtenerPorId(Long id) {
		return peliculas.get(id);
	}
	
	public static void insertar(Pelicula pelicula) {
		Long id = peliculas.lastKey() + 1;
		pelicula.setId(id);
		peliculas.put(pelicula.getId(), pelicula);
	}

	public static void modificar(Pelicula pelicula) {
		if(!peliculas.containsKey(pelicula.getId())) {
			throw new AccesoDatosException("No existe ese id");
		}
		peliculas.put(pelicula.getId(), pelicula);
	}

	public static void borrar(Long id) {
		if(!peliculas.containsKey(id)) {
			throw new AccesoDatosException("No existe ese id");
		}
		peliculas.remove(id);
	}
}

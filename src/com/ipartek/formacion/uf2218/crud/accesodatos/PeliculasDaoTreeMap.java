package com.ipartek.formacion.uf2218.crud.accesodatos;

import java.time.LocalDate;
import java.util.TreeMap;

import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

public final class PeliculasDaoTreeMap implements Dao<Pelicula> {

	//INICIO SINGLETON
	private PeliculasDaoTreeMap() {
		GenerosDaoTreeMap daoGenero = GenerosDaoTreeMap.getInstancia();
		peliculas.put(1L, new Pelicula(1L, "Indiana Jones", daoGenero.obtenerPorId(1L), daoGenero.obtenerPorId(5L),LocalDate.of(1980, 6, 5)));
		peliculas.put(2L, new Pelicula(2L, "Superman", daoGenero.obtenerPorId(2L), daoGenero.obtenerPorId(7L), LocalDate.of(1983, 1, 2)));
	}
	
	private static PeliculasDaoTreeMap instancia = new PeliculasDaoTreeMap();
	
	public static PeliculasDaoTreeMap getInstancia() {
		return instancia;
	}
	//FIN SINGLETON
	
	private TreeMap<Long, Pelicula> peliculas = new TreeMap<>();
	
	@Override
	public Iterable<Pelicula> obtenerTodos() {
		return peliculas.values();
	}

	@Override
	public Pelicula obtenerPorId(Long id) {
		return peliculas.get(id);
	}

	@Override
	public void insertar(Pelicula pelicula) {
		Long id = peliculas.lastKey() + 1;
		pelicula.setId(id);
		peliculas.put(pelicula.getId(), pelicula);
	}

	@Override
	public void modificar(Pelicula pelicula) {
		if(!peliculas.containsKey(pelicula.getId())) {
			throw new AccesoDatosException("No existe ese id");
		}
		peliculas.put(pelicula.getId(), pelicula);
	}
	
	@Override
	public void borrar(Long id) {
		if(!peliculas.containsKey(id)) {
			throw new AccesoDatosException("No existe ese id");
		}
		peliculas.remove(id);
	}

}

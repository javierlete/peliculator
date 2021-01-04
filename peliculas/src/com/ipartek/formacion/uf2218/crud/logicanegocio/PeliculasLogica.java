package com.ipartek.formacion.uf2218.crud.logicanegocio;

import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

public interface PeliculasLogica {
	Iterable<Pelicula> listarPeliculas();
	
	void anadirPelicula(Pelicula pelicula);
	void editarPelicula(Pelicula pelicula);
	void borrarPelicula(Long id);
}

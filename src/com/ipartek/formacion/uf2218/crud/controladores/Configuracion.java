package com.ipartek.formacion.uf2218.crud.controladores;

import com.ipartek.formacion.uf2218.crud.accesodatos.Dao;
import com.ipartek.formacion.uf2218.crud.accesodatos.GenerosDaoTreeMap;
import com.ipartek.formacion.uf2218.crud.accesodatos.PeliculasDaoJdbc;
import com.ipartek.formacion.uf2218.crud.modelos.Genero;
import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

public class Configuracion {
	public static Dao<Pelicula> dao = PeliculasDaoJdbc.getInstancia();
	public static Dao<Genero> daoGenero = GenerosDaoTreeMap.getInstancia();
}

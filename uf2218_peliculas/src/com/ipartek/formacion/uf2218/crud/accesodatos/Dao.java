package com.ipartek.formacion.uf2218.crud.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	void insertar(T objeto);
	void modificar(T objeto);
	void borrar(Long id);
}

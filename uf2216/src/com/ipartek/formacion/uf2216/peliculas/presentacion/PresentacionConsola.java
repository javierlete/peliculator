package com.ipartek.formacion.uf2216.peliculas.presentacion;

import static com.ipartek.formacion.uf2216.peliculas.bibliotecas.Consola.*;

import java.time.LocalDate;

import com.ipartek.formacion.uf2216.peliculas.entidades.EntidadesException;
import com.ipartek.formacion.uf2216.peliculas.accesodatos.AccesoDatosException;
import com.ipartek.formacion.uf2216.peliculas.accesodatos.PeliculasDAO;
import com.ipartek.formacion.uf2216.peliculas.entidades.Pelicula;

public class PresentacionConsola {

	public static void main(String[] args) {
		int opcion;

		do {
			menu();

			opcion = pedirOpcion();

			procesarOpcion(opcion);
		} while (opcion != 0);
	}

	private static void menu() {
		p("1. Listar todas las peliculas");
		p("2. Buscar por Id");
		p("3. Añadir");
		p("4. Modificar");
		p("5. Borrar");
		p();
		p("0. Salir");
	}

	private static int pedirOpcion() {
		return pedirInteger("¿Que opcion quieres?");
	}

	private static void procesarOpcion(int opcion) {
		p(opcion);

		switch (opcion) {
		case 1:
			listar();
			break;
		case 2:
			buscar();
			break;
		case 3:
			anadir();
			break;
		case 4:
			modificar();
			break;
		case 5:
			borrar();
			break;
		case 0:
			p("Gracias por usar esta aplicacion");
			break;
		default:
			p("No se reconoce esa opcion");
		}
	}

	private static void listar() {
		for (Pelicula pelicula : PeliculasDAO.obtenerTodas()) {
			mostrar(pelicula);
		}
	}

	private static void mostrar(Pelicula pelicula) {
		System.out.println();
		System.out.printf("%17s: %s%n", "Id", pelicula.getId());
		System.out.printf("%17s: %s%n", "Titulo", pelicula.getTitulo());
		System.out.printf("%17s: %s%n", "Genero", pelicula.getGenero());
		System.out.printf("%17s: %s%n", "Fecha de estreno", pelicula.getFechaEstreno());
		System.out.println();
	}

	private static void buscar() {
		Long id = pedirLong("¿Que id buscas?");

		Pelicula pelicula = PeliculasDAO.obtenerPorId(id);

		if (pelicula != null) {
			mostrar(pelicula);
		} else {
			p("No se ha encontrado la pelicula con id " + id);
		}
	}

	private static void anadir() {
		Pelicula pelicula = new Pelicula();

		pedirDatos(pelicula, p -> p.setTitulo(pedirTexto("Titulo")), p -> p.getTitulo());
		pedirDatos(pelicula, p -> p.setGenero(pedirTexto("Genero")), p -> p.getGenero());
		pedirDatos(pelicula, p -> p.setFechaEstreno(LocalDate.parse(pedirTexto("Fecha de estreno"))), p -> p.getFechaEstreno());
		
		PeliculasDAO.insertar(pelicula);
	}

	private static void pedirDatos(Pelicula pelicula, LambdaPeliculaCuerpo lpCuerpo,
			LambdaPeliculaCondicion lpCondicion) {
		do {
			try {
				lpCuerpo.ejecutar(pelicula);
			} catch (EntidadesException e) {
				p(e.getMessage());
			}
		} while (lpCondicion.ejecutar(pelicula) == null);
	}

	private static void modificar() {
		Pelicula pelicula = new Pelicula();

		pedirDatos(pelicula, p -> p.setId(pedirLong("Id")), p -> p.getId());
		pedirDatos(pelicula, p -> p.setTitulo(pedirTexto("Titulo")), p -> p.getTitulo());
		pedirDatos(pelicula, p -> p.setGenero(pedirTexto("Genero")), p -> p.getGenero());
		pedirDatos(pelicula, p -> p.setFechaEstreno(LocalDate.parse(pedirTexto("Fecha de estreno"))), p -> p.getFechaEstreno());
		
		PeliculasDAO.modificar(pelicula);
	}

	private static void borrar() {
		Long id = pedirLong("¿Que id quieres borrar?");
		
		try {
			PeliculasDAO.borrar(id);
		} catch(AccesoDatosException e) {
			p(e.getMessage());
		}
	}

}

package com.ipartek.formacion.uf2216.ejemplodao.presentacion;

import java.util.Scanner;

import com.ipartek.formacion.uf2216.ejemplodao.accesodatos.SuscriptorTreeMapDAO;
import com.ipartek.formacion.uf2216.ejemplodao.modelos.Suscriptor;

public class PresentacionConsola {

	private static final boolean SIN_ENTER = false;

	private static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;

		do {
			menu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != 0);
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
		listado();
	}

	private static void buscar() {
		p("¿Que id buscas? ", SIN_ENTER);
		Long id = s.nextLong();

		p(SuscriptorTreeMapDAO.obtenerPorId(id));
	}

	private static void anadir() {
		p("Id: ", SIN_ENTER);
		Long id = s.nextLong();
		s.nextLine();
		
		p("Nombre: ", SIN_ENTER);
		String nombre = s.nextLine();

		p("Apellidos: ", SIN_ENTER);
		String apellidos = s.nextLine();

		SuscriptorTreeMapDAO.insertar(new Suscriptor(id, nombre, apellidos));
	}

	private static void modificar() {
		p("Id: ", SIN_ENTER);
		Long id = s.nextLong();
		s.nextLine();

		p("Nombre: ", SIN_ENTER);
		String nombre = s.nextLine();

		p("Apellidos: ", SIN_ENTER);
		String apellidos = s.nextLine();

		SuscriptorTreeMapDAO.modificar(new Suscriptor(id, nombre, apellidos));
	}

	private static void borrar() {
		p("Id: ", SIN_ENTER);
		Long id = s.nextLong();

		SuscriptorTreeMapDAO.borrar(id);
	}

	private static int pedirOpcion() {
		p("¿Que opcion quieres? ", SIN_ENTER);
		return s.nextInt();
	}

	private static void menu() {
		p("1. Listar todos los suscriptores");
		p("2. Buscar por Id");
		p("3. Añadir");
		p("4. Modificar");
		p("5. Borrar");
		p();
		p("0. Salir");
	}

	private static void p(Object objeto, boolean conEnter) {
		if (conEnter) {
			p(objeto);
		} else {
			System.out.print(objeto);
		}
	}

	private static void p(Object objeto) {
		System.out.println(objeto);
	}

	private static void p() {
		System.out.println();
	}

	private static void listado() {
		System.out.println("-------");
		for (Suscriptor suscriptor : SuscriptorTreeMapDAO.obtenerTodos()) {
			System.out.println(suscriptor);
		}
		System.out.println("-------");
	}

	public static void mainPrueba(String[] args) {
		listado();

		System.out.println(SuscriptorTreeMapDAO.obtenerPorId(2L));

		SuscriptorTreeMapDAO.insertar(new Suscriptor(3L, "Nuevo", "Nuevez"));

		listado();

		Suscriptor suscriptor = SuscriptorTreeMapDAO.obtenerPorId(3L);

		suscriptor.setNombre("Modificado");
		suscriptor.setApellidos("Modificadez");

		SuscriptorTreeMapDAO.modificar(suscriptor); // new Suscriptor(3L, "Modificado", "Modificadez"));

		listado();

		SuscriptorTreeMapDAO.borrar(3L);

		listado();
	}
}

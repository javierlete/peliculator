package com.ipartek.formacion.uf2216.ejemplodao.presentacion;

import static com.ipartek.formacion.uf2216.bibliotecas.Consola.cerrarConsola;
import static com.ipartek.formacion.uf2216.bibliotecas.Consola.p;
import static com.ipartek.formacion.uf2216.bibliotecas.Consola.pedirInteger;
import static com.ipartek.formacion.uf2216.bibliotecas.Consola.pedirLong;
import static com.ipartek.formacion.uf2216.bibliotecas.Consola.pedirTexto;

import com.ipartek.formacion.uf2216.ejemplodao.accesodatos.AccesoDatosException;
import com.ipartek.formacion.uf2216.ejemplodao.accesodatos.BorrarException;
import com.ipartek.formacion.uf2216.ejemplodao.accesodatos.InsertarException;
import com.ipartek.formacion.uf2216.ejemplodao.accesodatos.SuscriptorTreeMapDAO;
import com.ipartek.formacion.uf2216.ejemplodao.entidades.EntidadesException;
import com.ipartek.formacion.uf2216.ejemplodao.entidades.Suscriptor;

public class PresentacionConsola {
	public static void main(String[] args) {
		try {
			int opcion;

			do {
				menu();
				opcion = pedirOpcion();
				procesarOpcion(opcion);
			} while (opcion != 0);
			
			cerrarConsola();
		} catch (Exception e) {
			p("Error no esperado");
			p(e.getMessage());
			p("Contacte con el servicio tecnico");
			
//			e.printStackTrace();
		}
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
		Long id = pedirLong("¿Que id buscas?");

		Suscriptor suscriptor = SuscriptorTreeMapDAO.obtenerPorId(id);
		
		if(suscriptor != null) {
			p(suscriptor);
		} else {
			p("No se ha encontrado el suscriptor con id " + id);
		}
	}

	private static void anadir() {	
		Suscriptor suscriptor = pedirDatosSuscriptor();
		
		try {
			SuscriptorTreeMapDAO.insertar(suscriptor);
		} catch (InsertarException e) {
			p(e.getMessage());
			p(SuscriptorTreeMapDAO.obtenerPorId(suscriptor.getId()));
		}
	}

	private static void modificar() {
		Suscriptor suscriptor = pedirDatosSuscriptor();
		
		try {
			SuscriptorTreeMapDAO.modificar(suscriptor);
		} catch (AccesoDatosException e) {
			p(e.getMessage());
		}
	}
	
	private static Suscriptor pedirDatosSuscriptor() {
		Suscriptor suscriptor = new Suscriptor();
		
		do {
			try {
				suscriptor.setId(pedirLong("Id"));
			} catch (EntidadesException e) {
				p(e.getMessage());
			}
		} while (suscriptor.getId() == null);
		
		do {
			try {
				suscriptor.setNombre(pedirTexto("Nombre"));
			} catch (EntidadesException e) {
				p(e.getMessage());
			}
		} while (suscriptor.getNombre() == null);
		
		do {
			try {
				suscriptor.setApellidos(pedirTexto("Apellidos"));
			} catch (EntidadesException e) {
				p(e.getMessage());
			}
		} while (suscriptor.getApellidos() == null);
		
		return suscriptor;
	}

	private static void borrar() {
		Long id = pedirLong("Id a borrar");

		try {
			SuscriptorTreeMapDAO.borrar(id);
		} catch (BorrarException e) {
			p(e.getMessage());
		}
	}

	private static int pedirOpcion() {
		return pedirInteger("¿Que opcion quieres?");
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

	private static void listado() {
		p("-------");
		for (Suscriptor suscriptor : SuscriptorTreeMapDAO.obtenerTodos()) {
			p(suscriptor);
		}
		p("-------");
	}

	public static void mainPrueba(String[] args) {
		listado();

		p(SuscriptorTreeMapDAO.obtenerPorId(2L));

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

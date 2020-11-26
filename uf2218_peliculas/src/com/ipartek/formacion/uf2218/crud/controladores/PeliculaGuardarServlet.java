package com.ipartek.formacion.uf2218.crud.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.uf2218.crud.accesodatos.AccesoDatosException;
import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

@WebServlet("/admin/guardar")
public class PeliculaGuardarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Recepción de parámetros
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String genero = request.getParameter("genero");
		String fechaEstreno = request.getParameter("fecha-estreno");
		
		// 2. Empaquetar en objeto del modelo (entidad)
		
		Pelicula pelicula = new Pelicula(id, titulo, genero, fechaEstreno);
		
		// 3. Tomar decisiones en base a los datos recibidos
		
		if(!pelicula.isCorrecto()) {
			request.setAttribute("pelicula", pelicula);
			request.getRequestDispatcher("/WEB-INF/vistas/admin/pelicula.jsp").forward(request, response);
			return;
		}
		
		String alertaMensaje, alertaTipo, op = null;
		
		try {
			if(pelicula.getId() == null) {
				op = "inserción";
				Configuracion.dao.insertar(pelicula);
				
			} else {
				op = "modificación";
				Configuracion.dao.modificar(pelicula);
			}
			
			alertaMensaje = "La " + op + " se ha hecho correctamente";
			alertaTipo = "success";
		} catch (AccesoDatosException e) {
			alertaMensaje = "Ha habido un error en la " + op + ": " + e.getMessage();
			alertaTipo = "danger";
		}
		
		// 4. Preparar el modelo para la siguiente pantalla
		HttpSession session = request.getSession();
		
		session.setAttribute("alertamensaje", alertaMensaje);
		session.setAttribute("alertatipo", alertaTipo);
		
		// 5. Redireccionar a la siguiente pantalla
		response.sendRedirect(request.getContextPath() + "/admin/listado");
	}

}

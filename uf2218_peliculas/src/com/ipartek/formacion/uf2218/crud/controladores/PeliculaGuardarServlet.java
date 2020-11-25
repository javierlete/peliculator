package com.ipartek.formacion.uf2218.crud.controladores;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.uf2218.crud.accesodatos.PeliculasDAO;
import com.ipartek.formacion.uf2218.crud.entidades.Pelicula;

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
		Long peliculaId = id.length() == 0 ? null : Long.parseLong(id);
		LocalDate peliculaFechaEstreno = LocalDate.parse(fechaEstreno, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		Pelicula pelicula = new Pelicula(peliculaId, titulo, genero, peliculaFechaEstreno);
		
		// 3. Tomar decisiones en base a los datos recibidos
		if(peliculaId == null) {
			PeliculasDAO.insertar(pelicula);
		} else {
			PeliculasDAO.modificar(pelicula);
		}
		
		// 4. Redireccionar a la siguiente pantalla
		response.sendRedirect(request.getContextPath() + "/admin/listado");
	}

}

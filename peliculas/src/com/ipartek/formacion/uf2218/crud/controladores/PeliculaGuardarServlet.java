package com.ipartek.formacion.uf2218.crud.controladores;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ipartek.formacion.uf2218.crud.accesodatos.AccesoDatosException;
import com.ipartek.formacion.uf2218.crud.modelos.Genero;
import com.ipartek.formacion.uf2218.crud.modelos.Pelicula;

@WebServlet("/admin/guardar")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class PeliculaGuardarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(PeliculaGuardarServlet.class.getName());

	private static final String UPLOAD_DIRECTORY = "imgs-pelis";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Cambiar la codificación a la hora de leer todos los parámetros a UTF8
		// request.setCharacterEncoding("utf8");

		// 1. Recepción de parámetros
		String id = request.getParameter("id");
		String titulo = request.getParameter("titulo");
		String generoTexto = request.getParameter("genero");
		String fechaEstreno = request.getParameter("fecha-estreno");
		
		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();

		LOGGER.info(uploadPath);
		
		String fileName;

		Part part = request.getPart("foto");

		fileName = part.getSubmittedFileName();

		LOGGER.info(fileName);

		String fichero = uploadPath + File.separator + id + ".jpg";
		part.write(fichero);
		
		LOGGER.info(fichero);

		// 2. Empaquetar en objeto del modelo (entidad)
		Long generoId = Long.parseLong(generoTexto);

		Genero genero = Configuracion.daoGenero.obtenerPorId(generoId);

		Pelicula pelicula = new Pelicula(id, titulo, genero, fechaEstreno);

		// 3. Tomar decisiones en base a los datos recibidos

		if (!pelicula.isCorrecto()) {
			request.setAttribute("pelicula", pelicula);
			request.getRequestDispatcher("/WEB-INF/vistas/admin/pelicula.jsp").forward(request, response);
			return;
		}

		String alertaMensaje, alertaTipo, op = null;

		try {
			if (pelicula.getId() == null) {
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

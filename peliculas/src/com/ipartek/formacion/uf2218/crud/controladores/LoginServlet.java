package com.ipartek.formacion.uf2218.crud.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login") //{"/", "/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if("javier@lete.com".equals(email) && "contra".equals(password)) {
			request.getSession().setAttribute("email", email);
			response.sendRedirect(request.getContextPath() + "/admin/listado");
		} else {
			request.setAttribute("alertamensaje", "El usuario o contraseña son incorrectos");
			request.setAttribute("alertatipo", "danger");
			request.setAttribute("email", email);
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}

}

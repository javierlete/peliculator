package com.ipartek.formacion.uf2218;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("La próxima vez lo envías por POST, ingeniero aeroespacial...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if("admin@ipartek.com".equals(email) && "contra".equals(password)) {
			//response.sendRedirect("bienvenida.html");
			request.setAttribute("email", email);
			request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.html");
		}
	}

}

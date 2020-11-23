package com.ipartek.formacion.uf2218;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/preferencias")
public class Preferencias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String colores = request.getParameter("colores");
		
		if(colores != null) {
			Cookie cookie = new Cookie("colores", colores);
			response.addCookie(cookie);
		}
		
		response.sendRedirect("preferencias.jsp");
		//request.getRequestDispatcher("preferencias.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

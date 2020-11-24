package com.ipartek.formacion.uf2218;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			HttpSession session = request.getSession();
			
			session.setAttribute("email", email);
			request.getRequestDispatcher("bienvenida.jsp").forward(request, response);
//			response.sendRedirect("bienvenida.jsp");
			
			//bienvenida(request, response);
			
//			bienvenida_jsp b = new bienvenida_jsp();
//			b._jspService(request, response);
		} else {
			request.setAttribute("email", email);
			request.setAttribute("error", "El usuario o contraseña son incorrectos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
//	private void bienvenida(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.getWriter().println(request.getAttribute("email"));
//	}

}

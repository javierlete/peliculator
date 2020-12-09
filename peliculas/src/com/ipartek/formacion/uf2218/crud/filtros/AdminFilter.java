package com.ipartek.formacion.uf2218.crud.filtros;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(AdminFilter.class.getName());
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		String email = (String) session.getAttribute("email");
		
		if(email == null) {
			LOGGER.warning("Un usuario anónimo ha intentado entrar en admin desde la IP " + req.getRemoteAddr());
			
			res.sendRedirect(req.getContextPath() + "/login");
			return;
		} else {
			LOGGER.info("El usuario " + email + " se ha logueado");
			
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}
	
	public void destroy() {}
}

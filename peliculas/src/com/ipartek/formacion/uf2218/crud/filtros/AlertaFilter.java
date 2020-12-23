package com.ipartek.formacion.uf2218.crud.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/listado")
public class AlertaFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		chain.doFilter(request, response);
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		session.removeAttribute("alertamensaje");
		session.removeAttribute("alertatipo");
		
		System.out.println("Borrando atributos");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

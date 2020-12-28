package com.ipartek.formacion.uf2218.crud.listeners;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import com.ipartek.formacion.uf2218.crud.filtros.AdminFilter;

@WebListener
public class RequestUtf8Listener implements ServletRequestListener {

	private static final Logger LOGGER = Logger.getLogger(AdminFilter.class.getName());
	
	public void requestDestroyed(ServletRequestEvent sre) {
	}

	public void requestInitialized(ServletRequestEvent sre) {
		try {
			LOGGER.finer("Cambio de codificación UTF8 para request");
			sre.getServletRequest().setCharacterEncoding("utf8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Codificación no soportada");
		}
	}

}

package com.ipartek.formacion.uf2218.crud.listeners;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class AplicacionListener
 *
 */
@WebListener
public class AplicacionListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

	private static final Logger LOGGER = Logger.getLogger(AplicacionListener.class.getName());
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOGGER.fine("Aplicación nueva arrancada");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOGGER.fine("Aplicación parada");		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		LOGGER.fine("Sesión creada");
		LOGGER.fine(se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		LOGGER.fine("Sesión destruída");
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		LOGGER.fine(se.getName());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {}
	
}

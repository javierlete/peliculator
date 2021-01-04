package com.ipartek.formacion.uf2218.crud.logicanegocio;

import com.ipartek.formacion.uf2218.crud.modelos.Usuario;

public class UsuariosLogicaImpl implements UsuariosLogica {

	private UsuariosLogicaImpl() {}
	
	private final static UsuariosLogicaImpl INSTANCIA = new UsuariosLogicaImpl();
	
	public static UsuariosLogicaImpl getInstancia() {
		return INSTANCIA;
	}
	
	@Override
	public boolean validarLogin(Usuario usuario) {
		return "javier@lete.com".equals(usuario.getEmail()) && "contra".equals(usuario.getPassword());
	}

}

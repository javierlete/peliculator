package com.ipartek.formacion.uf2218.crud.logicanegocio;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2218.crud.modelos.Usuario;

public class UsuariosLogicaTest {
	private static UsuariosLogica logica;
	
	@BeforeAll
	static void setUp() {
		logica = UsuariosLogicaImpl.getInstancia();
	}

	@Test
	void validarUsuarioTest() {
		Usuario usuarioOk = new Usuario(null, "javier@lete.com", "contra");
		assertTrue(logica.validarLogin(usuarioOk));
		
		Usuario usuarioKo = new Usuario(null, "lalara@laldsa.asdf", "asdfa");
		assertFalse(logica.validarLogin(usuarioKo));
	}

}

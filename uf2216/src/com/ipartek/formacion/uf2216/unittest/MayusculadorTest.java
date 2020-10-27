package com.ipartek.formacion.uf2216.unittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MayusculadorTest {

	@Test
	void test() {
		String resultado = Mayusculador.convertir("texto");
		
		assertEquals("TEXTO", resultado);
	}
}

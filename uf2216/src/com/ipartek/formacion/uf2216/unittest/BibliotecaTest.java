package com.ipartek.formacion.uf2216.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BibliotecaTest {

	// Antes de todos los @Test
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeAll");
	}

	// Despues de todos los @Test
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterAll");
	}

	// Antes de cada @Test
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("@BeforeEach");
	}

	// Despues de cada @Test
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("@AfterEach");
	}

	@Test
	void testSumar() {
		int resultado = Biblioteca.sumar(5, 6);
		
		assertEquals(11, resultado);
	}
	
	@Test
	void testRestar() {
		int resultado = Biblioteca.restar(5, 6);
		
		assertEquals(-1, resultado);
	}

}

package com.ipartek.formacion.uf2216.ejemplodao.accesodatos;

import static com.ipartek.formacion.uf2216.ejemplodao.accesodatos.SuscriptorTreeMapDAO.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.uf2216.ejemplodao.entidades.Suscriptor;

class SuscriptorTreeMapDAOTest {

	private static final Suscriptor DATO2 = new Suscriptor(2L, "Javier", "Lete");
	private static final Suscriptor DATO1 = new Suscriptor(1L, "Pepe", "Perez");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		suscriptores.put(1L, DATO1);
		suscriptores.put(2L, DATO2);
	}

	@AfterEach
	void tearDown() throws Exception {
		suscriptores.clear();
	}

	@Test
	void testObtenerTodos() {
		Iterable<Suscriptor> resultado = obtenerTodos();
		
		ArrayList<Suscriptor> esperado = new ArrayList<>();
		
		esperado.add(DATO1);
		esperado.add(DATO2);
		
		assertIterableEquals(esperado, resultado);
	}

	@Test
	void testObtenerPorId() {
		Suscriptor resultado = obtenerPorId(1L);
		
		assertEquals(DATO1, resultado);
		assertEquals(DATO2, obtenerPorId(2L));
		
		assertNull(obtenerPorId(5L));
	}

	@Test
	void testInsertar() {
		Suscriptor nuevo = new Suscriptor(3L, "Nuevo", "Nuevez");
		
		insertar(nuevo);
		
		Iterable<Suscriptor> resultado = obtenerTodos();
		
		ArrayList<Suscriptor> esperado = new ArrayList<>();
		
		esperado.add(DATO1);
		esperado.add(DATO2);
		esperado.add(nuevo);
		
		assertIterableEquals(esperado, resultado);
		
		assertThrows(AccesoDatosException.class, () -> insertar(new Suscriptor(2L, "Mal", "Hecho")));
		
		nuevo.setId(4L);
		
		assertDoesNotThrow( () -> insertar(nuevo));
	}

	@Test
	void testModificar() {
		Suscriptor modificado = new Suscriptor(2L, "Modificado", "Modificadez");
		
		modificar(modificado);
		
		Iterable<Suscriptor> resultado = obtenerTodos();
		
		ArrayList<Suscriptor> esperado = new ArrayList<>();
		
		esperado.add(DATO1);
		esperado.add(modificado);
		
		assertIterableEquals(esperado, resultado);
		
		assertThrows(AccesoDatosException.class, () -> modificar(new Suscriptor(7L, "Mal", "Hecho")));
		
		modificado.setId(1L);
		
		assertDoesNotThrow( () -> modificar(modificado));
	}

	@Test
	void testBorrar() {
		borrar(1L);
		
		Iterable<Suscriptor> resultado = obtenerTodos();
		
		ArrayList<Suscriptor> esperado = new ArrayList<>();
		
		esperado.add(DATO2);
		
		assertIterableEquals(esperado, resultado);
		
		assertThrows(AccesoDatosException.class, () -> borrar(7L));
		
		assertDoesNotThrow( () -> borrar(2L) );
	}

}

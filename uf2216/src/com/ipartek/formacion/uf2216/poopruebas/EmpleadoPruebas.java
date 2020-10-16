package com.ipartek.formacion.uf2216.poopruebas;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.ipartek.formacion.uf2216.poo.abstractas.Empleado;
import com.ipartek.formacion.uf2216.poo.abstractas.EmpleadoIndefinido;
import com.ipartek.formacion.uf2216.poo.abstractas.EmpleadoPorHoras;

public class EmpleadoPruebas {

	public static void main(String[] args) {
		ArrayList<Number> numeros = new ArrayList<>();
		
		numeros.add(5);
		numeros.add(5.2);
		
		for(Number numero: numeros) {
			System.out.println(numero.doubleValue());
			System.out.println(numero.intValue());
		}
		
		ArrayList<Empleado> plantilla = new ArrayList<>();
		
		plantilla.add(new EmpleadoIndefinido(1L, "Javier", new BigDecimal(23456), 14));
		plantilla.add(new EmpleadoPorHoras(2L, "Pepe", new BigDecimal(30), 80));
		
		for(Empleado empleado: plantilla) {
			System.out.println(empleado);
			System.out.println(empleado.getSueldoMensual());
		}
	}
}

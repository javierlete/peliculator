package com.ipartek.formacion.uf2216.poopruebas;

import java.util.ArrayList;

import com.ipartek.formacion.uf2216.poo.interfaces.Balon;
import com.ipartek.formacion.uf2216.poo.interfaces.Comestible;
import com.ipartek.formacion.uf2216.poo.interfaces.Esferico;
import com.ipartek.formacion.uf2216.poo.interfaces.Naranja;

public class Interfaces {

	public static void main(String[] args) {
		ArrayList<Esferico> bolsa = new ArrayList<>();

		bolsa.add(new Naranja());
		bolsa.add(new Balon());

		for (Esferico esferico : bolsa) {
			esferico.rodar();

			if (esferico instanceof Comestible) {
				((Comestible) esferico).comer();
			}
		}
	}
}

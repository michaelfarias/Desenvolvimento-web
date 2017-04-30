package br.ufc.crateus.web.application4.repository;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.web.application4.model.Matricula;

public class MatriculasRepositorio {

	private static List<Matricula> list = new ArrayList<>();

	public static void add(Matricula m) {
		list.add(m);
	}

	public static List<Matricula> getMatriculas() {
		return list;
	}

	
	
}

package br.ufc.crateus.web.application4.repository;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.web.application4.model.Disciplina;

public class DisciplinaRepositorio {

	private static List<Disciplina> listDisciplina = new ArrayList<>();

	public static void add(Disciplina d) {
		listDisciplina.add(d);
	}

	public static List<Disciplina> getDisciplinas() {
		return listDisciplina;
	}

}

package br.ufc.crateus.web.application8.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufc.crateus.web.application8.model.Disciplina;

public class DisciplinaRepository {

	private static List<Disciplina> disciplinas = new ArrayList<>();
	private static int id = 1;

	public static List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public static void adicionar(Disciplina disciplina) {
		disciplina.setId(id++);
		disciplinas.add(disciplina);
	}

	public static Disciplina getById(int id) {
		for (Iterator<Disciplina> it = disciplinas.iterator(); it.hasNext();) {
			Disciplina disciplina = it.next();
			if (disciplina.getId() == id) {
				return disciplina;
			}
		}
		return null;
	}

	public static void update(Disciplina newDisciplina) {
		for (Iterator<Disciplina> it = disciplinas.iterator(); it.hasNext();) {
			Disciplina disciplina = it.next();
			if (disciplina.getId() == newDisciplina.getId()) {
				disciplina.setNome(newDisciplina.getNome());
				disciplina.setCargaHoraria(newDisciplina.getCargaHoraria());
				return;
			}
		}
	}

	public static void delete(Disciplina deleted) {
		for (Iterator<Disciplina> it = disciplinas.iterator(); it.hasNext();) {
			Disciplina disciplina = it.next();
			if (disciplina.getId() == deleted.getId()) {
				it.remove();
				return;
			}
		}
	}

}

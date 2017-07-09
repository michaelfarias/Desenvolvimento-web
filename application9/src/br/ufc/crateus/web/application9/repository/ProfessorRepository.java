package br.ufc.crateus.web.application9.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufc.crateus.web.application9.model.Professor;

public class ProfessorRepository {

	private static List<Professor> professores = new ArrayList<>();
	private static int id = 1;

	public static List<Professor> getProfessores() {
		return professores;
	}

	public static Professor getById(int id) {
		for (Iterator<Professor> it = professores.iterator(); it.hasNext();) {
			Professor professor = it.next();
			if (professor.getId() == id) {
				return professor;
			}
		}
		return null;
	}

	public static void adicionar(Professor professor) {
		professor.setId(id++);
		professores.add(professor);
	}

	public static void update(Professor newProfessor) {
		for (Iterator<Professor> it = professores.iterator(); it.hasNext();) {
			Professor professor = it.next();
			if (professor.getId() == newProfessor.getId()) {
				professor.setNome(newProfessor.getNome());
				return;
			}
		}
	}

	public static void delete(Professor deleted) {
		for (Iterator<Professor> it = professores.iterator(); it.hasNext();) {
			Professor professor = it.next();
			if (professor.getId() == deleted.getId()) {
				it.remove();
				return;
			}
		}
		System.out.println("Delete - Id not found: " + deleted.getId());
	}

}

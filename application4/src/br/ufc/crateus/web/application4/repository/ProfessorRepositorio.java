package br.ufc.crateus.web.application4.repository;

import br.ufc.crateus.web.application4.model.Professor;

public class ProfessorRepositorio extends AbstractRepositorio<Professor> {

	private static ProfessorRepositorio repositorio;

	public static synchronized ProfessorRepositorio getInstance() {
		if (repositorio == null)
			repositorio = new ProfessorRepositorio();

		return repositorio;
	}

	private ProfessorRepositorio() {
		add(new Professor("michael", "4"));
		add(new Professor("maria", "4"));
	}

	public Professor getByLogin(String login) {
		for (Professor p : repository.values()) {
			if (p.getNome().equals(login))
				return p;
		}
		return null;
	}

}

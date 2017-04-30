package br.ufc.crateus.web.application4.repository;

import br.ufc.crateus.web.application4.model.Aluno;

public class AlunoRepositorio extends AbstractRepositorio<Aluno> {

	private static AlunoRepositorio repositorio;

	public static synchronized AlunoRepositorio getInstance() {
		if (repositorio == null)
			repositorio = new AlunoRepositorio();

		return repositorio;
	}

	private AlunoRepositorio() {
		add(new Aluno("michael", "5", "345", "asd@", "5"));
		add(new Aluno("jose", "5", "345", "asd@", "jose"));
		
	}

	public Aluno getByLogin(String login) {
		for (Aluno a : repository.values()) {
			if (a.getNome().equals(login))
				return a;
		}
		return null;
	}

}

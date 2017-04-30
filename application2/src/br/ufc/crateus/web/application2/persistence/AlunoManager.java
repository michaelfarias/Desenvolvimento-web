package br.ufc.crateus.web.application2.persistence;

import java.util.HashMap;
import java.util.Map;

import br.ufc.crateus.web.application2.entidades.Aluno;

public class AlunoManager {

	private static Map<Integer, Aluno> alunos = new HashMap<>();
	private static int idAluno = 0;

	public static void addAluno(Aluno aluno) {

		aluno.setId(++idAluno);
		alunos.put(idAluno, aluno);
	}

	public static Map<Integer, Aluno> getAlunos() {
		return alunos;
	}

}

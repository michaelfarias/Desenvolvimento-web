package br.ufc.crateus.web.application3.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.web.application3.entidades.Matricula;
import br.ufc.crateus.web.application3.entidades.Turma;
import br.ufc.crateus.web.application3.entidades.Aluno;

public class MatriculaManager {

	private static List<Matricula> addTurmaAluno = new ArrayList<>();

	public static void matricular(Turma turma, Aluno aluno) {
		Matricula matricula = new Matricula(turma, aluno);
		addTurmaAluno.add(matricula);
	}

	public static List<Matricula> getAlunoMatriculados() {
		return addTurmaAluno;
	}

	public static boolean verifica(Turma turma, Aluno aluno) {

		for (Matricula alunosMatriculados : getAlunoMatriculados())
			if (alunosMatriculados.getTurma().equals(turma) && alunosMatriculados.getAluno().equals(aluno))
				return true;

		return false;
	}

}

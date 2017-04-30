package br.ufc.crateus.web.application2.persistence;

import java.util.ArrayList;
import java.util.List;

import br.ufc.crateus.web.application2.entidades.Aluno;
import br.ufc.crateus.web.application2.entidades.Matricula;
import br.ufc.crateus.web.application2.entidades.Turma;

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

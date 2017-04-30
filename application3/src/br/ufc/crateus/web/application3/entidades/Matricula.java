package br.ufc.crateus.web.application3.entidades;

import br.ufc.crateus.web.application3.entidades.Turma;
import br.ufc.crateus.web.application3.entidades.Aluno;

public class Matricula {

	private Aluno aluno;
	private Turma turma;

	public Matricula(Turma turma, Aluno aluno) {
		setAluno(aluno);
		setTurma(turma);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}

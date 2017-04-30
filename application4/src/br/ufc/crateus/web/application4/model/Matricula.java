package br.ufc.crateus.web.application4.model;

public class Matricula {
	
	Aluno aluno;
	Disciplina disciplina;

	public Matricula(Aluno aluno, Disciplina disciplina) {
		this.aluno = aluno;
		this.disciplina = disciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}

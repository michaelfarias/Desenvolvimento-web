package br.ufc.crateus.web.application6.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Matricula {

	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private Aluno aluno;
	@OneToOne
	private Disciplina disciplina;

	public Matricula() {
	}

	public Matricula(Aluno aluno, Disciplina disciplina) {
		setAluno(aluno);
		setDisciplina(disciplina);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

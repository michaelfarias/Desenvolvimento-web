package br.ufc.crateus.web.application11.model;

public class Matricula {

	private int id;
	private Aluno aluno;
	private Disciplina disciplina;
	private String periodo;
	private double nota;

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

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", aluno=" + aluno + ", disciplina=" + disciplina + ", periodo=" + periodo
				+ ", nota=" + nota + "]";
	}

}

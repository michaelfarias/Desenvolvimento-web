package br.ufc.crateus.web.application9.model;

public class Matricula {

	private int id;
	private Aluno aluno;
	private String periodo;
	private Disciplina disciplina;
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

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Matricula [aluno=" + aluno + ", periodo=" + periodo + ", disciplina=" + disciplina + ", nota=" + nota
				+ "]";
	}

}

package br.ufc.crateus.web.application8.model;

import java.util.List;

public class Professor {

	private int id;
	private String nome;
	private List<Disciplina> disciplinas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", disciplinas=" + disciplinas + "]";
	}

}

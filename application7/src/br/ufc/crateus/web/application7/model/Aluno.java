	package br.ufc.crateus.web.application7.model;

import java.util.Date;

public class Aluno {

	private int id;
	private String nome;
	private String matricula;
	private Date dataNascimento;

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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNacimento) {
		this.dataNascimento = dataNacimento;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", dataNacimento=" + dataNascimento
				+ "]";
	}
}

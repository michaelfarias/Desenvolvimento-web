package br.ufc.crateus.web.application1.entidades;

public class Aluno {
	private String nome;
	private String telefone;

	public Aluno(String nome, String telefone) {
		setNome(nome);
		setTelefone(telefone);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

}

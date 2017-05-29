package br.ufc.crateus.web.application7.model;

public class Professor {

	private int id;
	private String nome;
	private String formacao;

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

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", formacao=" + formacao + "]";
	}

}

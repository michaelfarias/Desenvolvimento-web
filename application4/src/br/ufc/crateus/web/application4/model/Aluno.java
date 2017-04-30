package br.ufc.crateus.web.application4.model;


public class Aluno extends Usuario {

	private String cpf;
	private String telefone;
	private String email;

	public Aluno(String nome, String cpf, String telefone, String email, String senha) {
		super(nome, senha);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

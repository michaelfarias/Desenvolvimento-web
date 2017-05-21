package br.ufc.crateus.web.application6.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aluno extends Usuario {

	@Id
	@GeneratedValue
	private int id;
	private String cpf;
	private String telefone;
	private String email;

	public Aluno() {
	}

	public Aluno(String nome, String senha, String cpf, String telefone, String email) {
		super(nome, senha);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

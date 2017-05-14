package br.ufc.crateus.web.application6.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disciplina {
 
	@Id
	@GeneratedValue
	private int id;
	private String nome;

	public Disciplina() {
	
	}

	public Disciplina(String nome) {
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}

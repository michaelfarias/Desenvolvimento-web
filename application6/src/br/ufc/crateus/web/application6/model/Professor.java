package br.ufc.crateus.web.application6.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor extends Usuario {

	public Professor() {

	}

	public Professor(String nome, String senha) {
		super(nome, senha);

	}

}

package br.ufc.crateus.web.application6.persistence;

import javax.persistence.PersistenceException;

import br.ufc.crateus.web.application6.model.Aluno;
import br.ufc.crateus.web.application6.model.Professor;
import br.ufc.crateus.web.application6.model.Usuario;

public class UsuarioManager {

	public static Usuario getUsuario(String nome, String senha) {
		Aluno aluno = getAluno(nome, senha);
		Professor professor = getProfessor(nome, senha);
		return professor != null ? professor : (aluno != null ? aluno : null);

	}

	private static Professor getProfessor(String nome, String senha) {
		try {
			return Entity.getEm().createQuery("SELECT p FROM Usuario u JOIN Professor p ON p.id = u.id WHERE u.nome ='"
					+ nome + "' AND u.senha = '" + senha + "'", Professor.class).getSingleResult();
		} catch (PersistenceException ex) {
			if (Entity.getEm().isOpen())
				Entity.getEm().getTransaction().rollback();
			ex.printStackTrace();
		}

		return null;
	}

	private static Aluno getAluno(String nome, String senha) {
		try {
			return Entity.getEm().createQuery("SELECT a FROM Usuario u JOIN Aluno a ON u.id = a.id WHERE u.nome ='"
					+ nome + "' AND u.senha = '" + senha + "'", Aluno.class).getSingleResult();
		} catch (PersistenceException ex) {
			if (Entity.getEm().isOpen())
				Entity.getEm().getTransaction().rollback();
			ex.printStackTrace();
		}
		return null;
	}
}

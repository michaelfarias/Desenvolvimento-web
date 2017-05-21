package br.ufc.crateus.web.application6.persistence;

import java.util.List;

import javax.persistence.PersistenceException;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import br.ufc.crateus.web.application6.model.Disciplina;
import br.ufc.crateus.web.application6.model.Matricula;

public class MatriculaManager {

	private static int idAluno;

	public static void addMatricula(Matricula matricula) {
		Entity.getEm().persist(matricula);
		Entity.getEm().getTransaction().commit();
	}

	public static List<Disciplina> getMatriculas() {

		try {
			return Entity.getEm()
					.createQuery("SELECT m.disciplina FROM Matricula m WHERE m.aluno.id =  " + getIdAluno(),
							Disciplina.class)
					.getResultList();

		} catch (PersistenceException ex) {
			if (Entity.getEm().isOpen())
				Entity.getEm().getTransaction().rollback();
			ex.printStackTrace();

		}
		return null;
	}

	public static void setIdAluno(int id) {
		idAluno = id;
	}

	private static int getIdAluno() {
		return idAluno;
	}
}

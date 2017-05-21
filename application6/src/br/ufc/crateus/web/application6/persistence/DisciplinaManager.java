package br.ufc.crateus.web.application6.persistence;

import java.util.List;

import javax.persistence.PersistenceException;

import br.ufc.crateus.web.application6.model.Disciplina;

public class DisciplinaManager {

	public static List<Disciplina> getDisciplinas() {
		List<Disciplina> disciplina = null;
		try {
			disciplina = Entity.getEm().createQuery("SELECT disciplina FROM Disciplina disciplina", Disciplina.class)
					.getResultList();
			return disciplina;
		} catch (PersistenceException ex) {
			if (Entity.getEm().isOpen())
				Entity.getEm().getTransaction().rollback();
			ex.printStackTrace();
		}
		return disciplina;
	}

	public static Disciplina getDisciplina(int id) {
		Disciplina disciplina = null;
		try {
			disciplina = Entity.getEm()
					.createQuery("SELECT disciplina FROM Disciplina disciplina WHERE disciplina.id = " + id,
							Disciplina.class)
					.getSingleResult();
			return disciplina;
		} catch (PersistenceException ex) {
			if (Entity.getEm().isOpen())
				Entity.getEm().getTransaction().rollback();
			ex.printStackTrace();
		}
		return disciplina;
	}

	public static void addDisciplia(Disciplina disciplina) {
		Entity.getEm().persist(disciplina);
		Entity.getEm().getTransaction().commit();
	}

}

package br.ufc.crateus.web.application8.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufc.crateus.web.application8.model.Matricula;

public class MatriculaRepository {

	private static List<Matricula> matriculas = new ArrayList<>();
	private static int id = 1;

	public static List<Matricula> getMatriculas() {
		return matriculas;
	}

	public static Matricula getById(int id) {
		for (Iterator<Matricula> it = matriculas.iterator(); it.hasNext();) {
			Matricula matricula = it.next();
			if (matricula.getAluno().getId() == id) {
				return matricula;
			}
		}
		return null;
	}

	public static Matricula getById(int id, int id_diciplina, String periodo) {
		for (Iterator<Matricula> it = matriculas.iterator(); it.hasNext();) {
			Matricula matricula = it.next();

			if (matricula.getAluno().getId() == id && matricula.getDisciplina().getId() == id_diciplina
					&& matricula.getPeriodo().equals(periodo)) {
				return matricula;
			}
		}
		return null;
	}

	public static void adicionar(Matricula matricula) {
		matricula.setId(id++);
		matriculas.add(matricula);
	}

	public static void update(Matricula newMatricula) {
		for (Iterator<Matricula> it = matriculas.iterator(); it.hasNext();) {
			Matricula matricula = it.next();
			if (matricula.getAluno().getId() == newMatricula.getAluno().getId()
					&& matricula.getDisciplina().getId() == newMatricula.getDisciplina().getId()
					&& matricula.getPeriodo().equals(newMatricula.getPeriodo())) {

				matricula.setAluno(newMatricula.getAluno());
				matricula.setDisciplina(newMatricula.getDisciplina());
				matricula.setPeriodo(newMatricula.getPeriodo());
				matricula.setNota(newMatricula.getNota());
				
				return;
			}
		}
	}

}

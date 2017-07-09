package br.ufc.crateus.web.application11.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufc.crateus.web.application11.model.Matricula;

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

	public static Matricula getByAlunoDisciplinaPeriodo(Matricula newMatricula) {
		for (Iterator<Matricula> it = matriculas.iterator(); it.hasNext();) {
			Matricula matricula = it.next();

			if (matricula.getAluno().getId() == newMatricula.getAluno().getId()
					&& matricula.getDisciplina().getId() == newMatricula.getDisciplina().getId()
					&& matricula.getDisciplina().getPeriodo().equals(newMatricula.getDisciplina().getPeriodo())) {
				return matricula;
			}
		}
		return null;
	}

	public static boolean contemNota(Matricula matricula) {
		for (Iterator<Matricula> it = matriculas.iterator(); it.hasNext();) {
			Matricula mat = it.next();

			if (mat.getId() == matricula.getId()) {
				if (mat.getNota() != -1)
					return true;
			}
		}
		return false;
	}

	public static void adicionar(Matricula matricula) {
		matricula.setId(id++);
		matricula.setNota(-1);
		matricula.setPeriodo(matricula.getDisciplina().getPeriodo());
		matriculas.add(matricula);
	}

	public static void update(Matricula updateMatricula) {
		for (Iterator<Matricula> it = matriculas.iterator(); it.hasNext();) {
			Matricula matricula = it.next();
			if (matricula.getAluno().getId() == updateMatricula.getAluno().getId()
					&& matricula.getDisciplina().getId() == updateMatricula.getDisciplina().getId()
					&& matricula.getDisciplina().getPeriodo().equals(updateMatricula.getDisciplina().getPeriodo())) {

//				matricula.setAluno(updateMatricula.getAluno());
//				matricula.setDisciplina(updateMatricula.getDisciplina());
//				matricula.getDisciplina().setPeriodo((updateMatricula.getDisciplina().getPeriodo()));
				matricula.setNota(updateMatricula.getNota());

				return;
			}
		}
	}

}

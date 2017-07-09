package br.ufc.crateus.web.application11.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.ufc.crateus.web.application11.model.Aluno;

public class AlunoRepository {

	private static List<Aluno> alunos = new ArrayList<>();
	private static int id = 1;

	public static List<Aluno> getAlunos() {
		return alunos;
	}

	public static Aluno getById(int id) {
		for (Iterator<Aluno> it = alunos.iterator(); it.hasNext();) {
			Aluno aluno = it.next();
			if (aluno.getId() == id) {
				return aluno;
			}
		}
		System.out.println("Id not found: " + id);
		return null;
	}

	public static void adicionar(Aluno aluno) {
		aluno.setId(id++);
		alunos.add(aluno);
	}

	public static void update(Aluno newAluno) {
		for (Iterator<Aluno> it = alunos.iterator(); it.hasNext();) {
			Aluno aluno = it.next();
			if (aluno.getId() == newAluno.getId()) {
				aluno.setMatricula(newAluno.getMatricula());
				aluno.setNome(newAluno.getNome());
				aluno.setEmail(newAluno.getEmail());
				aluno.setUsuario(newAluno.getUsuario());
				System.out.println("Updated: " + aluno);
				return;
			}
		}
	}

	public static void delete(Aluno deleted) {
		for (Iterator<Aluno> it = alunos.iterator(); it.hasNext();) {
			Aluno aluno = it.next();
			if (aluno.getId() == deleted.getId()) {
				it.remove();
				return;
			}
		}
		System.out.println("Delete - Id not found: " + deleted.getId());
	}
}

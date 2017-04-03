package br.ufc.crateus.web.application1.entidades;

import java.util.ArrayList;
import java.util.List;

public class Alunos {

	private static List<Aluno> listAluno = new ArrayList<>();

	public static List<Aluno> getAlunos() {

		listAluno.add(new Aluno("Jose", "656546"));
		listAluno.add(new Aluno("Casimiro", "123236"));
		listAluno.add(new Aluno("Jõao", "159465"));
		listAluno.add(new Aluno("Antônio", "159753"));
		listAluno.add(new Aluno("Mazé", "714825"));
		listAluno.add(new Aluno("Maria", "12365"));

		return listAluno;
	}

}

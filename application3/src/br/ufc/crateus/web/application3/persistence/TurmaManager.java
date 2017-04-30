package br.ufc.crateus.web.application3.persistence;

import java.util.HashMap;
import java.util.Map;

import br.ufc.crateus.web.application3.entidades.Turma;

public class TurmaManager {
	private static Map<String, Turma> turmas = new HashMap<>();

	public static void addTurma(Turma turma) {
		turmas.put(turma.getCodigo(), turma);

	}

	public static Map<String, Turma> getTurmas() {
		return turmas;
	}
}

package br.ufc.crateus.web.application4.view.bean;

import java.util.List;

import br.ufc.crateus.web.application4.model.Disciplina;
import br.ufc.crateus.web.application4.repository.DisciplinaRepositorio;

public class DisciplinasBean {

	public List<Disciplina> getDisciplina() {
		return DisciplinaRepositorio.getDisciplinas();
	}

}

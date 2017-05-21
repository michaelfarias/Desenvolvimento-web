package br.ufc.crateus.web.application6.view.bean;

import java.util.List;

import br.ufc.crateus.web.application6.model.Disciplina;
import br.ufc.crateus.web.application6.persistence.DisciplinaManager;

public class DisciplinaBean {

	public List<Disciplina> getDisciplinas() {
		return DisciplinaManager.getDisciplinas();
	}

}

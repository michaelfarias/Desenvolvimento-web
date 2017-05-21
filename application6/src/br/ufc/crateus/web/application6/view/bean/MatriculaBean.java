package br.ufc.crateus.web.application6.view.bean;

import java.util.List;

import br.ufc.crateus.web.application6.model.Disciplina;
import br.ufc.crateus.web.application6.persistence.MatriculaManager;

public class MatriculaBean {

	public List<Disciplina> getMatriculas() {
		return MatriculaManager.getMatriculas();
	}
}

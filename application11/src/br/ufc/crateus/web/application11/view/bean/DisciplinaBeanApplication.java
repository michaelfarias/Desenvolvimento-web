package br.ufc.crateus.web.application11.view.bean;

import java.util.List;

import javax.faces.bean.ApplicationScoped;

import br.ufc.crateus.web.application11.model.Disciplina;
import br.ufc.crateus.web.application11.repository.DisciplinaRepository;

@ApplicationScoped
public class DisciplinaBeanApplication {

	public List<Disciplina> getDisciplinas() {
		return DisciplinaRepository.getDisciplinas();
	}

}

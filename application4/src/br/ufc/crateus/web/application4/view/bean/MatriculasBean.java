package br.ufc.crateus.web.application4.view.bean;

import java.util.List;

import br.ufc.crateus.web.application4.model.Matricula;
import br.ufc.crateus.web.application4.repository.MatriculasRepositorio;

public class MatriculasBean {

	public List<Matricula> getMatriculas() {
		return MatriculasRepositorio.getMatriculas();
	}

}

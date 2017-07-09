package br.ufc.crateus.web.application9.view.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.ufc.crateus.web.application9.model.Matricula;
import br.ufc.crateus.web.application9.repository.MatriculaRepository;

@ManagedBean
public class MatriculaBean {

	private Matricula matricula;

	public MatriculaBean() {
		this.matricula = new Matricula();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Matricula> getMatriculas() {
		return MatriculaRepository.getMatriculas();
	}

	public String salvar() {
		if (MatriculaRepository.getById(matricula.getAluno().getId(), matricula.getDisciplina().getId(),
				matricula.getPeriodo()) == null) {
			MatriculaRepository.adicionar(matricula);

		} else {
			MatriculaRepository.update(matricula);
		}
		return "";
	}

	public String update() {
		System.out.println("ah:" + matricula.getPeriodo());
		Matricula matr = MatriculaRepository.getById(matricula.getAluno().getId(), matricula.getDisciplina().getId(),
				matricula.getPeriodo());
		if (matr != null && matr.getNota() == -1) {

			MatriculaRepository.update(matricula);
		}
		return "/index";
	}

}

package br.ufc.crateus.web.application8.view.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.ufc.crateus.web.application8.model.Disciplina;
import br.ufc.crateus.web.application8.repository.DisciplinaRepository;

@ManagedBean
public class DisciplinaBean {

	private Disciplina disciplina;

	public DisciplinaBean() {
		disciplina = new Disciplina();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getDisciplinas() {
		return DisciplinaRepository.getDisciplinas();
	}

	public String remover(Disciplina disciplina) {
		DisciplinaRepository.delete(disciplina);
		setDisciplina(new Disciplina());
		return "/disciplina";
	}

	public String carregar(Disciplina disciplina) {
		System.out.println("Carregar - " + disciplina);
		setDisciplina(disciplina);
		return "/disciplina";
	}

	public String salvar() {
		if (DisciplinaRepository.getById(getDisciplina().getId()) == null) {
			DisciplinaRepository.adicionar(getDisciplina());
			setDisciplina(new Disciplina());
			return "/disciplina";
		}

		DisciplinaRepository.update(getDisciplina());
		setDisciplina(new Disciplina());
		return "/disciplina";
	}
}

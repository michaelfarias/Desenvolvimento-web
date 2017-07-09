package br.ufc.crateus.web.application10.view.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ufc.crateus.web.application10.model.Disciplina;
import br.ufc.crateus.web.application10.repository.DisciplinaRepository;

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
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Disciplina removida com sucesso!", ""));
		return "";
	}

	public String carregar(Disciplina disciplina) {
		setDisciplina(disciplina);
		return "";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (DisciplinaRepository.getById(getDisciplina().getId()) == null) {
			DisciplinaRepository.adicionar(getDisciplina());
			context.addMessage(null, new FacesMessage("Disciplina cadastrada com sucesso!", disciplina.toString()));

			setDisciplina(new Disciplina());
			return "";
		}

		DisciplinaRepository.update(getDisciplina());
		context.addMessage(null, new FacesMessage("Disciplina atualizada com sucesso!", ""));
		setDisciplina(new Disciplina());
		return "";
	}
}

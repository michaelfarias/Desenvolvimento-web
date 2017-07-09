package br.ufc.crateus.web.application10.view.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ufc.crateus.web.application10.model.Professor;
import br.ufc.crateus.web.application10.repository.ProfessorRepository;

@ManagedBean
public class ProfessorBean {

	private Professor professor;

	public ProfessorBean() {
		professor = new Professor();

	}

	public Professor getProfessor() {
		return professor;
	}

	public List<Professor> getProfessores() {
		return ProfessorRepository.getProfessores();
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String remover(Professor professor) {
		ProfessorRepository.delete(professor);
		setProfessor(new Professor());
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Professor removido com sucesso!", ""));
		return "/professor";
	}

	public String carregar(Professor professor) {
		setProfessor(professor);
		return "/cadastrarProfessor";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (ProfessorRepository.getById(getProfessor().getId()) == null) {
			ProfessorRepository.adicionar(getProfessor());
			context.addMessage(null, new FacesMessage("Professor cadastrado com sucesso!", professor.toString()));
			setProfessor(new Professor());
			return "/professor";
		}

		ProfessorRepository.update(getProfessor());
		context.addMessage(null, new FacesMessage("Professor atualizado com sucesso!", ""));
		setProfessor(new Professor());
		return "/professor";
	}

	public String addDisciplina() {
		System.out.println(professor);
		return "";
	}

}

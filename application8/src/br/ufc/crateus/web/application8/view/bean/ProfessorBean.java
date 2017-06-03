package br.ufc.crateus.web.application8.view.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.ufc.crateus.web.application8.model.Professor;
import br.ufc.crateus.web.application8.repository.ProfessorRepository;

@ManagedBean
public class ProfessorBean {

	private Professor professor;

	public ProfessorBean() {
		professor = new Professor();

	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessores() {
		return ProfessorRepository.getProfessores();
	}

	public String remover(Professor professor) {
		ProfessorRepository.delete(professor);
		setProfessor(new Professor());
		return "/professor";
	}

	public String carregar(Professor professor) {
		System.out.println("Carregar - " + professor);
		setProfessor(professor);
		return "/professor";
	}

	public String salvar() {
		if (ProfessorRepository.getById(getProfessor().getId()) == null) {
			ProfessorRepository.adicionar(getProfessor());
			setProfessor(new Professor());
			return "/professor";
		}

		ProfessorRepository.update(getProfessor());
		setProfessor(new Professor());
		return "/professor";
	}

	public String addDisciplina() {
		System.out.println(professor);
		return "";
	}

}

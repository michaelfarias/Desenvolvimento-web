package br.ufc.crateus.web.application11.view.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ufc.crateus.web.application11.model.Professor;
import br.ufc.crateus.web.application11.model.Usuario;
import br.ufc.crateus.web.application11.repository.ProfessorRepository;
import br.ufc.crateus.web.application11.tst.TST;

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

	public List<String> professores(String g) {
		TST<String> tst = new TST<>();

		for (Professor p : ProfessorRepository.getProfessores())
			tst.put(p.getNome(), "");

		return (List<String>) tst.keysWithPrefix(g);

	}

	public String remover(Professor professor) {
		ProfessorRepository.delete(professor);
		setProfessor(new Professor());
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Professor removido com sucesso!", ""));
		return "";
	}

	public String carregar(Professor professor) {
		setProfessor(professor);
		return "";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario user = (Usuario) context.getApplication().createValueBinding("#{loginBean.usuario}").getValue(context);
		if (ProfessorRepository.getById(getProfessor().getId()) == null) {

			getProfessor().setUsuario(user);
			ProfessorRepository.adicionar(getProfessor());
			context.addMessage(null, new FacesMessage("Professor cadastrado com sucesso!", professor.toString()));
			setProfessor(new Professor());
			return "";
		}
		getProfessor().setUsuario(user);
		ProfessorRepository.update(getProfessor());
		context.addMessage(null, new FacesMessage("Professor atualizado com sucesso!", ""));
		setProfessor(new Professor());
		return "";
	}

	public String addDisciplina() {
		System.out.println(professor);
		return "";
	}

}

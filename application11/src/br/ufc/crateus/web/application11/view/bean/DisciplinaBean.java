package br.ufc.crateus.web.application11.view.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ufc.crateus.web.application11.model.Disciplina;
import br.ufc.crateus.web.application11.model.Usuario;
import br.ufc.crateus.web.application11.repository.DisciplinaRepository;
import br.ufc.crateus.web.application11.repository.ProfessorRepository;

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
		Usuario user = (Usuario) context.getApplication().createValueBinding("#{loginBean.usuario}")
				.getValue(context);
		if (DisciplinaRepository.getById(getDisciplina().getId()) == null) {

			disciplina.setProfessor(
					ProfessorRepository.getById(ProfessorRepository.getByNome(disciplina.getProfessor().getNome())));

			if (disciplina.getProfessor() != null) {
				
				getDisciplina().setUsuario(user);
				DisciplinaRepository.adicionar(getDisciplina());
				context.addMessage(null, new FacesMessage("Disciplina cadastrada com sucesso!", disciplina.toString()));
			} else
				context.addMessage(null, new FacesMessage("Não existe esse professor", ""));

			setDisciplina(new Disciplina());
			return "";
		}
		getDisciplina().setUsuario(user);
		DisciplinaRepository.update(getDisciplina());
		context.addMessage(null, new FacesMessage("Disciplina atualizada com sucesso!", ""));
		setDisciplina(new Disciplina());
		return "";
	}

	public String update() {

		setDisciplina(new Disciplina());
		return "";

	}
}

package br.ufc.crateus.web.application11.view.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ufc.crateus.web.application11.model.Matricula;
import br.ufc.crateus.web.application11.repository.MatriculaRepository;

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
		FacesContext context = FacesContext.getCurrentInstance();
		if (MatriculaRepository.getByAlunoDisciplinaPeriodo(matricula) == null) {
			MatriculaRepository.adicionar(matricula);
			setMatricula(new Matricula());
			context.addMessage(null, new FacesMessage("Aluno matriculado com sucesso!", ""));

		} else {
			context.addMessage(null, new FacesMessage("Aluno já está matriculado!", ""));
		}
		return "";
	}

	public String update() {

		// MatriculaRepository.update(matricula);
		setMatricula(new Matricula());
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Nota adicionada com sucesso", ""));
		// System.out.println("veio");
		return "";
	}

}

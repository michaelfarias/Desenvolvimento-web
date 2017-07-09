package br.ufc.crateus.web.application10.view.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.ufc.crateus.web.application10.model.Aluno;
import br.ufc.crateus.web.application10.repository.AlunoRepository;

@ManagedBean
public class AlunoBean {

	private Aluno aluno;

	public AlunoBean() {
		aluno = new Aluno();
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		return AlunoRepository.getAlunos();
	}

	public String remover(Aluno aluno) {
		FacesContext context = FacesContext.getCurrentInstance();
		AlunoRepository.delete(aluno);
		setAluno(new Aluno());
		context.addMessage(null, new FacesMessage("Aluno removido com sucesso!", ""));
		return "/listarAlunos";
	}

	public String carregar(Aluno aluno) {
		setAluno(aluno);
		return "/cadastrarAluno";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (AlunoRepository.getById(getAluno().getId()) == null) {
			AlunoRepository.adicionar(getAluno());
			context.addMessage(null, new FacesMessage("Aluno cadastrado com sucesso!", aluno.toString()));
			setAluno(new Aluno());
			return "/aluno";
		}

		AlunoRepository.update(getAluno());
		context.addMessage(null, new FacesMessage("Aluno atualizado com sucesso!", ""));

		setAluno(new Aluno());
		return "/aluno";

	}
}

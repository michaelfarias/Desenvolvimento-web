package br.ufc.crateus.web.application11.view.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import br.ufc.crateus.web.application11.model.Aluno;
import br.ufc.crateus.web.application11.model.Usuario;
import br.ufc.crateus.web.application11.repository.AlunoRepository;

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

	public List<Aluno> alunos(String a) {
		return AlunoRepository.getAlunos();
	}

	public String remover(Aluno aluno) {
		FacesContext context = FacesContext.getCurrentInstance();
		AlunoRepository.delete(aluno);
		setAluno(new Aluno());
		context.addMessage(null, new FacesMessage("Aluno removido com sucesso!", ""));
		return "";
	}

	public String carregar(Aluno aluno) {

		setAluno(aluno);
		System.out.println(getAluno().getId() + "asd");
		return "";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario user = (Usuario) context.getApplication().createValueBinding("#{loginBean.usuario}").getValue(context);

		if (AlunoRepository.getById(getAluno().getId()) == null) {

			getAluno().setUsuario(user);
			AlunoRepository.adicionar(getAluno());
			context.addMessage(null, new FacesMessage("Aluno cadastrado com sucesso!", aluno.toString()));
			setAluno(new Aluno());
			return "";
		}
		getAluno().setUsuario(user);
		AlunoRepository.update(getAluno());
		context.addMessage(null, new FacesMessage("Aluno atualizado com sucesso!", ""));

		setAluno(new Aluno());
		return "";

	}
}

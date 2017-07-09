package br.ufc.crateus.web.application9.view.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.ufc.crateus.web.application9.model.Aluno;
import br.ufc.crateus.web.application9.repository.AlunoRepository;

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
		AlunoRepository.delete(aluno);
		setAluno(new Aluno());
		return "/aluno";
	}

	public String carregar(Aluno aluno) {
		System.out.println("Carregar - " + aluno);
		setAluno(aluno);
		return "/aluno";
	}

	public String salvar() {
		if (AlunoRepository.getById(getAluno().getId()) == null) {
			AlunoRepository.adicionar(getAluno());
			setAluno(new Aluno());
			return "/aluno";
		}

		AlunoRepository.update(getAluno());
		setAluno(new Aluno());
		return "/aluno";
	}
}

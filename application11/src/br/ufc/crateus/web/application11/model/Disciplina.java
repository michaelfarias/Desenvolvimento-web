package br.ufc.crateus.web.application11.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

public class Disciplina {

	private int id;
	private String nome;
	private int cargaHoraria;
	private String periodo;
	private Professor professor;
	private List<Aluno> alunos;
	@ManagedProperty("#{loginBean.usuario}")
	private Usuario usuario;

	public Disciplina() {
		this.professor = new Professor();
		this.alunos = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + ", periodo=" + periodo
				+ ", professor=" + professor + ", alunos=" + alunos + "]";
	}

}

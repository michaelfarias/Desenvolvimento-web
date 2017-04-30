package br.ufc.crateus.web.application3.entidades;

public class Turma {
	private String codigo;
	private String disciplina;
	private String periodo;
	private String creditos;

	public Turma(String codigo, String disciplina, String periodo, String creditos) {

		setCodigo(codigo);
		setDisciplina(disciplina);
		setPeriodo(periodo);
		setCreditos(creditos);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo2) {
		this.periodo = periodo2;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos2) {
		this.creditos = creditos2;
	}

}

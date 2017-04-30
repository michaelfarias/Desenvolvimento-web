package br.ufc.crateus.web.application3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application3.entidades.*;
import br.ufc.crateus.web.application3.persistence.AlunoManager;
import br.ufc.crateus.web.application3.persistence.MatriculaManager;
import br.ufc.crateus.web.application3.persistence.TurmaManager;
import br.ufc.crateus.web.application3.servletexception.MatriculaException;
import br.ufc.crateus.web.application3.entidades.Aluno;
@WebServlet("/matriculaServlet")
public class MatriculasServlet extends HttpServlet {

	private static final long serialVersionUID = -1881562050621960158L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		matricular(req);

		PrintWriter out = resp.getWriter();
		out.print(
				"<html><head></head><script language = JavaScript>" + "location.href='matriculas.jsp'</script></html>");

	}

	private void matricular(HttpServletRequest req) throws MatriculaException {

		int id_aluno = Integer.parseInt(req.getParameter("aluno"));
		String codigo_turma = req.getParameter("codigo");

		Turma turma = TurmaManager.getTurmas().get(codigo_turma);
		Aluno aluno = AlunoManager.getAlunos().get(id_aluno);

		if (MatriculaManager.verifica(turma, aluno))
			throw new MatriculaException();

		else
			MatriculaManager.matricular(turma, aluno);

	}

}
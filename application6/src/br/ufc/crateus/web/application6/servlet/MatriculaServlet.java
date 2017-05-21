package br.ufc.crateus.web.application6.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application6.model.Aluno;
import br.ufc.crateus.web.application6.model.Disciplina;
import br.ufc.crateus.web.application6.model.Matricula;
import br.ufc.crateus.web.application6.persistence.DisciplinaManager;
import br.ufc.crateus.web.application6.persistence.MatriculaManager;

@WebServlet("/matricular")
public class MatriculaServlet extends HttpServlet {

	private static final long serialVersionUID = 7551540825015684125L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Aluno aluno = (Aluno) req.getSession().getAttribute("usuario");
		Disciplina disciplina = DisciplinaManager.getDisciplina(Integer.parseInt(req.getParameter("id_disciplina")));

		MatriculaManager.addMatricula(new Matricula(aluno, disciplina));

		getServletContext().getRequestDispatcher("/aluno").forward(req, resp);

	}
}

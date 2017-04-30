package br.ufc.crateus.web.application4.view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application4.model.Aluno;
import br.ufc.crateus.web.application4.model.Disciplina;
import br.ufc.crateus.web.application4.model.Matricula;
import br.ufc.crateus.web.application4.repository.DisciplinaRepositorio;
import br.ufc.crateus.web.application4.repository.MatriculasRepositorio;

@WebServlet("/matriculaAluno")
public class MatriculaAlunoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5653576655754665832L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Aluno aluno = (Aluno) req.getSession().getAttribute("usuario");
		String disciplina = req.getParameter("disci");

		Matricula mr = new Matricula(aluno, new Disciplina(disciplina));

		MatriculasRepositorio.add(mr);

		getServletContext().getRequestDispatcher("/aluno").forward(req, resp);
	}

}

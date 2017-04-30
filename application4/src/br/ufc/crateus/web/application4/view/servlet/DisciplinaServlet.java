package br.ufc.crateus.web.application4.view.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application4.model.Disciplina;
import br.ufc.crateus.web.application4.repository.DisciplinaRepositorio;

@WebServlet("/cadastrarDisciplina")
public class DisciplinaServlet extends HttpServlet {

	private static final long serialVersionUID = 300617471183931561L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String disciplina = req.getParameter("disciplina");
		Disciplina d = new Disciplina(disciplina);
		DisciplinaRepositorio.add(d);

		getServletContext().getRequestDispatcher("/professor").forward(req, resp);
	}
}

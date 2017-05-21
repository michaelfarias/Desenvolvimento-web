package br.ufc.crateus.web.application6.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application6.model.Disciplina;
import br.ufc.crateus.web.application6.persistence.DisciplinaManager;

@WebServlet("/cadastrarDisciplina")
public class CadastrarDisciplinaServlet extends HttpServlet {

	private static final long serialVersionUID = -919941200590853343L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		DisciplinaManager.addDisciplia(new Disciplina(req.getParameter("disciplina")));
		getServletContext().getRequestDispatcher("/professor").forward(req, resp);
	}
}

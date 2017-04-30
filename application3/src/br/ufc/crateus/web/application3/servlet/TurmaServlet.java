package br.ufc.crateus.web.application3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application3.entidades.Turma;
import br.ufc.crateus.web.application3.persistence.TurmaManager;
import br.ufc.crateus.web.application3.servletexception.CadastroTurmaException;

@WebServlet("/turmaServlet")
public class TurmaServlet extends HttpServlet {

	private static final long serialVersionUID = 6496853512857963408L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String codigo = req.getParameter("codigo");

		TurmaManager.getTurmas().remove(codigo);
		PrintWriter out = resp.getWriter();
		out.print("<html><head></head><script language = JavaScript>" + "location.href='turmas.jsp'</script></html>");

	}

	// @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addTurma(req);

		PrintWriter out = resp.getWriter();
		out.print("<html><head></head><script language = JavaScript>" + "location.href='turmas.jsp'</script></html>");

	}

	private void addTurma(HttpServletRequest req) throws CadastroTurmaException {

		String codigo = req.getParameter("codigo");
		String disciplina = req.getParameter("disciplina");
		String periodo = req.getParameter("periodo");
		String creditos = req.getParameter("creditos");

		if (codigo.equals("") || disciplina.equals("") || periodo.equals("") || creditos.equals("")
				|| TurmaManager.getTurmas().containsKey(codigo))
			throw new CadastroTurmaException();

		else
			TurmaManager.addTurma(new Turma(codigo, disciplina, periodo, creditos));

	}
}

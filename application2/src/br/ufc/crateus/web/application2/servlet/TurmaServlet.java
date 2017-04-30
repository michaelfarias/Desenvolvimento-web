package br.ufc.crateus.web.application2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application2.entidades.Turma;
import br.ufc.crateus.web.application2.persistence.TurmaManager;
import br.ufc.crateus.web.application2.servletexception.CadastroTurmaException;

@WebServlet("/turmaServlet")
public class TurmaServlet extends HttpServlet {

	private static final long serialVersionUID = 6496853512857963408L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title>Alunos</title></head><body>");
		out.println("<table border = 5 align = center>");
		out.println("<tr>");
		out.println("<th>CODIGO</th>");
		out.println("<th>DISCIPLINA</th>");
		out.println("<th>PERIODO</th>");
		out.println("<th>CRÉDITOS</th>");
		out.println("</tr>");

		if (!TurmaManager.getTurmas().isEmpty())
			for (Turma turma : TurmaManager.getTurmas().values()) {
				out.println("<tr>");
				out.println("<th>" + turma.getCodigo() + "</th>");
				out.println("<th>" + turma.getDisciplina() + "</th>");
				out.println("<th>" + turma.getPeriodo() + "</th>");
				out.println("<th>" + turma.getCreditos() + "</th>");
				out.println("</tr>");
			}

		out.println("</table>");
		out.println("<a href=cadastrar-turma.html>Cadastrar turma</a>");
		out.println("<a href=index.html>Voltar</a>");
		out.println("</body>");
		out.println("</html>");

	}

	// @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addTurma(req);

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title>Alunos</title></head><body>");
		out.println("<table border = 5 align = center>");
		out.println("<tr>");
		out.println("<th>CODIGO</th>");
		out.println("<th>DISCIPLINA</th>");
		out.println("<th>PERIODO</th>");
		out.println("<th>CRÉDITOS</th>");
		out.println("</tr>");

		for (Turma turma : TurmaManager.getTurmas().values()) {
			out.println("<tr>");
			out.println("<th>" + turma.getCodigo() + "</th>");
			out.println("<th>" + turma.getDisciplina() + "</th>");
			out.println("<th>" + turma.getPeriodo() + "</th>");
			out.println("<th>" + turma.getCreditos() + "</th>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("<a href=cadastrar-turma.html>Cadastrar turma</a>");
		out.println("<a href=index.html>Voltar</a>");
		out.println("</body>");
		out.println("</html>");
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

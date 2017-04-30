package br.ufc.crateus.web.application2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application2.entidades.*;
import br.ufc.crateus.web.application2.persistence.AlunoManager;
import br.ufc.crateus.web.application2.persistence.MatriculaManager;
import br.ufc.crateus.web.application2.persistence.TurmaManager;
import br.ufc.crateus.web.application2.servletexception.MatriculaException;

@WebServlet("/matriculasServlet")
public class MatriculasServlet extends HttpServlet {

	private static final long serialVersionUID = -1881562050621960158L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		matricular(req);

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title>Matrículas</title></head><body>");
		out.println("<table border = 5 align = center>");
		out.println("<tr>");
		out.println("<th>CÓDIGO DA DISCIPLINA</th>");
		out.println("<th>NOME DA DISCIPLINA</th>");
		out.println("<th>CPF DO ALUNO</th>");
		out.println("<th>NOME DO ALUNO</th>");
		out.println("<th>PERIÓDO</th>");
		out.println("</tr>");

		for (Matricula alunosMatriculados : MatriculaManager.getAlunoMatriculados()) {
			out.println("<tr>");
			out.println("<th>" + alunosMatriculados.getTurma().getCodigo() + "</th>");
			out.println("<th>" + alunosMatriculados.getTurma().getDisciplina() + "</th>");
			out.println("<th>" + alunosMatriculados.getAluno().getCpf() + "</th>");
			out.println("<th>" + alunosMatriculados.getAluno().getNome() + "</th>");
			out.println("<th>" + alunosMatriculados.getTurma().getPeriodo() + "</th>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<a href=matricular.html>Matricular</a>");
		out.println("<a href=index.html>Voltar</a>");

		out.println("</body>");
		out.println("</html>");

	}

	private void matricular(HttpServletRequest req) throws MatriculaException {

		if (!(req.getParameter("id_aluno") == null && req.getParameter("codigo_turma") == null)) {

			if (!req.getParameter("id_aluno").equals("")) {
				int id_aluno = Integer.parseInt(req.getParameter("id_aluno"));
				String codigo_turma = req.getParameter("codigo_turma");

				if (AlunoManager.getAlunos().containsKey(id_aluno)
						&& TurmaManager.getTurmas().containsKey(codigo_turma)) {

					Turma turma = TurmaManager.getTurmas().get(codigo_turma);
					Aluno aluno = AlunoManager.getAlunos().get(id_aluno);

					if (MatriculaManager.verifica(turma, aluno))
						throw new MatriculaException();

					else
						MatriculaManager.matricular(turma, aluno);
				}

				else
					throw new MatriculaException();
			}

			else
				throw new MatriculaException();

		}
	}

}
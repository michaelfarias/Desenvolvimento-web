package br.ufc.crateus.web.application2.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application2.entidades.Aluno;
import br.ufc.crateus.web.application2.persistence.AlunoManager;
import br.ufc.crateus.web.application2.servletexception.CadastroAlunoException;
import javafx.scene.control.TreeTableRow;

@WebServlet("/alunoServlet")
public class AlunoServlet extends HttpServlet {

	private static final long serialVersionUID = 659905453600799219L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>Alunos</title></head><body>");
		out.println("<table border = 5 align = center>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>NOME</th>");
		out.println("<th>CPF</th>");
		out.println("<th>TELEFONE</th>");
		out.println("<th>EMAIL</th>");
		out.println("</tr>");

		if (!AlunoManager.getAlunos().isEmpty())

			for (Aluno aluno : AlunoManager.getAlunos().values()) {
				out.println("<tr>");
				out.println("<th>" + aluno.getId() + "</th>");
				out.println("<th>" + aluno.getNome() + "</th>");
				out.println("<th>" + aluno.getCpf() + "</th>");
				out.println("<th>" + aluno.getTelefone() + "</th>");
				out.println("<th>" + aluno.getEmail() + "</th>");
				out.println("</tr>");
			}

		out.println("</table>");
		out.println("<a href=cadastrar-aluno.html>Cadastrar aluno</a>");
		out.println("<a href=index.html>Voltar</a>");
		out.println("</body>");
		out.println("</html>");

	}

	// @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addAluno(req);
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title>Alunos</title></head><body>");
		out.println("<table border = 5 align = center>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>NOME</th>");
		out.println("<th>CPF</th>");
		out.println("<th>TELEFONE</th>");
		out.println("<th>EMAIL</th>");
		out.println("</tr>");

		for (Aluno aluno : AlunoManager.getAlunos().values()) {
			out.println("<tr>");
			out.println("<th>" + aluno.getId() + "</th>");
			out.println("<th>" + aluno.getNome() + "</th>");
			out.println("<th>" + aluno.getCpf() + "</th>");
			out.println("<th>" + aluno.getTelefone() + "</th>");
			out.println("<th>" + aluno.getEmail() + "</th>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("<a href=cadastrar-aluno.html>Cadastrar aluno</a>");
		out.println("<a href=index.html>Voltar</a>");
		out.println("</body>");
		out.println("</html>");

	}

	private void addAluno(HttpServletRequest req) throws CadastroAlunoException {

		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String telefone = req.getParameter("telefone");
		String email = req.getParameter("email");

		if (nome.equals("") || cpf.equals("") || telefone.equals("") || email.equals(""))
			throw new CadastroAlunoException();

		else
			AlunoManager.addAluno(new Aluno(nome, cpf, telefone, email));

	}

}

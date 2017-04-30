package br.ufc.crateus.web.application3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application3.persistence.AlunoManager;
import br.ufc.crateus.web.application3.servletexception.CadastroAlunoException;
import br.ufc.crateus.web.application3.entidades.Aluno;

@WebServlet("/alunoServlet")
public class AlunoServlet extends HttpServlet {

	private static final long serialVersionUID = 659905453600799219L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Aluno aluno = AlunoManager.getAlunos().get(Integer.parseInt(req.getParameter("id")));

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.print("<script language=JavaScript> location.href='atualizaAluno.jsp?id=" + aluno.getId() + "&nome="
				+ aluno.getNome() + "&cpf=" + aluno.getCpf() + "&email=" + aluno.getEmail() + "&telefone="
				+ aluno.getTelefone() + "'</script>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addAluno(req);

		PrintWriter out = resp.getWriter();
		out.print("<html><head></head><script language = JavaScript>" + "location.href='alunos.jsp'</script></html>");
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

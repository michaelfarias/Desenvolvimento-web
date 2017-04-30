package br.ufc.crateus.web.application3.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application3.persistence.AlunoManager;
import br.ufc.crateus.web.application3.entidades.Aluno;

@WebServlet("/atualizaAlunoServlet")
public class atualizaAlunoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		System.out.println(id);
		String nome = req.getParameter("nome");
		String cpf = req.getParameter("cpf");
		String email = req.getParameter("email");
		String telefone = req.getParameter("telefone");

		AlunoManager.update(id, new Aluno(nome, cpf, telefone, email));

		PrintWriter out = resp.getWriter();
		out.print("<html><head></head><script language = JavaScript>" + "location.href='alunos.jsp'</script></html>");

	}

}

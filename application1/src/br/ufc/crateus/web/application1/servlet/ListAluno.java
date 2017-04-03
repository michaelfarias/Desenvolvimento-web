package br.ufc.crateus.web.application1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.crateus.web.application1.entidades.*;

@WebServlet("/alunos")
public class ListAluno extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head><title> Lista de Alunos</title>");
		out.println("</head>");
		out.println("<body> <table border ='1'>");
		out.print("<tr>");
		out.print("<th> Nome do aluno</th>");
		out.print("<th> Telefone</th> ");
		out.print("</tr>");
		for (Aluno aluno : Alunos.getAlunos()) {
			out.print("<tr>");
			out.print("<td>" + aluno.getNome() + "</td>");
			out.print("<td>" + aluno.getTelefone() + "</td>");
			;
		}

		out.println("</table><a href='professores'>alskd</a> </body>");
		out.println("<html>");

	}

}

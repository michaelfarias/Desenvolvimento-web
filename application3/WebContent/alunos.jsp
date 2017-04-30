<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="br.ufc.crateus.web.application3.persistence.AlunoManager"%>
<%@ page import="br.ufc.crateus.web.application3.entidades.Aluno"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1px;" align="center">
		<tr>
			<th>Id</th>

			<th>Nome</th>

			<th>Cpf</th>

			<th>Email</th>

			<th>Telefone</th>

			<th>Editar</th>
		</tr>
		<%
			for (Aluno aluno : AlunoManager.getAlunos().values()) {
				out.println("<tr>");
				out.println("<th>" + aluno.getId() + "</th>");
				out.println("<th>" + aluno.getNome() + "</th>");
				out.println("<th>" + aluno.getCpf() + "</th>");
				out.println("<th>" + aluno.getEmail() + "</th>");
				out.println("<th>" + aluno.getTelefone() + "</th>");
				out.println("<th><a href=alunoServlet?id=" + aluno.getId() + ">Editar</a> </th>");
				out.println("</tr>");

			}
		%>

	</table>

	<a href="cadastrar-aluno.html">Cadastrar Aluno</a>
	<a href="index.html">Voltar</a>

</body>
</html>
<%@page
	import="br.ufc.crateus.web.application3.persistence.MatriculaManager"%>
<%@page import="br.ufc.crateus.web.application3.entidades.Matricula"%>
<%@page
	import="br.ufc.crateus.web.application3.persistence.AlunoManager"%>
<%@page import="br.ufc.crateus.web.application3.entidades.Aluno"%>
<%@page
	import="br.ufc.crateus.web.application3.persistence.TurmaManager"%>
<%@page import="br.ufc.crateus.web.application3.entidades.Turma"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="matriculaServlet" method="get">
		Aluno: <select name="aluno">
			<%
				for (Aluno aluno : AlunoManager.getAlunos().values()) {
			%>
			<option value=<%=aluno.getId()%>><%=aluno.getNome()%></option>
			<%
				}
			%>
		</select> <br> <br>Turma: <select name=codigo>
			<%
				for (Turma turma : TurmaManager.getTurmas().values()) {
			%>
			<option value=<%=turma.getCodigo()%>>
				<%=turma.getDisciplina()%> -
				<%=turma.getPeriodo()%></option>
			<%
				}
			%>
		</select><br> <input type="submit" value="matricular">

	</form>

	<table border="1px" align="center">
		<tr>
			<th>Código da disciplina</th>
			<th>Nome da disciplina</th>
			<th>Cpf do aluno</th>
			<th>Nome do aluno</th>
			<th>Periodo</th>
		</tr>
		<%
			for (Matricula matricula : MatriculaManager.getAlunoMatriculados()) {
		%>
		<tr>
			<th><%=matricula.getTurma().getCodigo()%></th>
			<th><%=matricula.getTurma().getDisciplina()%></th>
			<th><%=matricula.getAluno().getCpf()%></th>
			<th><%=matricula.getAluno().getNome()%></th>
			<th><%=matricula.getTurma().getPeriodo()%></th>
		</tr>

		<%
			}
		%>

	</table>
	<a href="index.html">Voltar</a>
</body>
</html>
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
	<table border="1px" align="center">
		<tr>
			<th>Código</th>
			<th>Disciplina</th>
			<th>Periodo</th>
			<th>Crédito</th>
			<th>Remover</th>

		</tr>
		<%
			for (Turma turma : TurmaManager.getTurmas().values()) {
		%>
		<tr>
			<th><%=turma.getCodigo()%></th>
			<th><%=turma.getDisciplina()%></th>
			<th><%=turma.getPeriodo()%></th>
			<th><%=turma.getCreditos()%></th>
			<th><a href=turmaServlet?codigo=<%=turma.getCodigo()%>>Remover
			</a></th>
		</tr>

		<%
			}
		%>
		</tr>
	</table>

	<a href="cadastrar-turma.html">cadastrarTurma</a>
	<a href="index.html">Voltar</a>

</body>
</html>
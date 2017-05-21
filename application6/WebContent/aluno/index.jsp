<%@page
	import="br.ufc.crateus.web.application6.persistence.MatriculaManager"%>
<%@page import="br.ufc.crateus.web.application6.model.Aluno"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<jsp:useBean id="mat"
	class="br.ufc.crateus.web.application6.view.bean.MatriculaBean"></jsp:useBean>
<body>
	<%
		Aluno aluno = (Aluno) request.getSession().getAttribute("usuario");
		MatriculaManager.setIdAluno(aluno.getId());
	%>
	<a href="matricula.jsp">matricular em disciplina</a>
	<a href="/application6/logout">sair</a>
	<br>
	<br>
	<table border="1px">
		<tr>
			<td>Suas disciplinas</td>
		</tr>
		<c:forEach var="md" items="${mat.matriculas}">

			<tr>
				<td>${md.nome}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>

	<c:import url="/tabelaDisciplina.jsp"></c:import>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="bean"
	class="br.ufc.crateus.web.application4.view.bean.MatriculasBean"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/logout" var="logout"></c:url>
	<a href="${logout}">Sair</a>
	<br>
	<a href="matricula.jsp">Matricular em disciplina</a>

	<center>
		<h2>Suas matriculas</h2>
	</center>
	<table border="1px" align=center>
		<tr>
			<th>Nome da disciplina</th>
		</tr>
		<c:forEach var="dp" items="${bean.matriculas}">
			<c:if test="${dp.aluno==usuario }">
				<tr>
					<th>${dp.disciplina.nome}</th>
				</tr>

			</c:if>
		</c:forEach>
	</table>


	<center>
		<h2>Disciplinas Existentes</h2>
	</center>
	<c:import url="/tabela-disciplina.jsp"></c:import>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.ufc.crateus.web.application4.model.Usuario"%>
<jsp:useBean id="bean"
	class="br.ufc.crateus.web.application4.view.bean.DisciplinasBean"></jsp:useBean>

<! DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	Escolha a disciplina:
	<form action="/application4/matriculaAluno" method="get">
		<select name="disci">
			<c:forEach var="d" items="${bean.disciplina}">
				<option name=${d.nome }>${d.nome}</option>
			</c:forEach>
		</select><br> <br>
		<input type="submit" value="matricular">
	</form>

</body>
</html>
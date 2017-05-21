<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="bean"
	class="br.ufc.crateus.web.application6.view.bean.DisciplinaBean"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>


	<form action="/application6/matricular" method="post">
		<select name="id_disciplina">
			<c:forEach var="d" items="${bean.disciplinas}">
				<option value="${d.id}">${d.nome}</option>
			</c:forEach>
		</select> <br> <input type="submit" value="matricular">
	</form>

</body>
</html>
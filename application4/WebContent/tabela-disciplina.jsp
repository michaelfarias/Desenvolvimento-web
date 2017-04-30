
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="bean"
	class="br.ufc.crateus.web.application4.view.bean.DisciplinasBean"></jsp:useBean>

<table border="1px" align=center>
	<tr>
		<td>Nome da disciplina</td>
	</tr>

	<c:forEach var="d" items="${bean.disciplina}">
		<tr>
			<td>${d.nome}</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>
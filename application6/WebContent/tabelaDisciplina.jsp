<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="bean"
	class="br.ufc.crateus.web.application6.view.bean.DisciplinaBean"></jsp:useBean>



<table border="1px">

	<tr>
		<td>Nome da disciplina</td>
	</tr>
	<c:forEach var="d" items="${bean.disciplinas}">
		<tr>
			<td>${d.nome}</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="atualizaAlunoServlet" method="post">
		Id: <input type=text name=id value=${param.id } readonly></br>
		Nome: <input type=text name=nome value=${param.nome}></br> Cpf: <input
			type=text name=cpf value=${param.cpf}></br> Email: <input
			type=text name=email value=${param.email}></br> Telefone: <input
			type=text name=telefone value=${param.telefone}></br> <input
			type="submit" value="atualizar">
	</form>
</body>
</html>
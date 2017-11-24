<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="formularioJogo">Criar novo Jogo</a>

	<br />
	<br />

	<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
		</tr>
		<c:forEach items="${listaJogos}" var="jogo">
			<tr>
				<td>${jogo.id}</td>
				<td>${jogo.nome}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
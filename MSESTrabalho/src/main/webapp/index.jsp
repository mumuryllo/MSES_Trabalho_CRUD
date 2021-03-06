<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1 class="title">Lista de Carros</h1>
    <hr>
	<form action="Controller" method="post">
		<button class="btn btn-primary"type="submit" name="option" value="insertForm">Cadastrar Carros</button>
	</form>
	
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Ano</th>
					<th scope="col">Modelo</th>
					<th scope="col">Acoes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="carro" items="${listUser}">
					<tr>
						<form action="Controller" method="post">
							 <td>
								<c:out value="${carro.id}"/>
								<input type="hidden" name="id" value="${carro.id}"/>
							</td>
							<td><c:out value="${carro.ano}"/></td>
							<td><c:out value="${carro.modelo}"/></td>
							<td>
							<button class="btn btn-primary" type="submit" name="option" value="delete" style="margin-right: 10px;" >Deletar</button>
                                <button class="btn btn-primary" type="submit" name="option" value="updateForm">Atualizar</button>
                            </td>
						</form>
					</tr>
				</c:forEach>
			</tbody>

		</table>
</div>
</body>
</html>
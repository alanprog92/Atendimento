<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>AppPedido</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Atendimento</h2>
	  <p>Projeto de Gestão de Atendimentos</p>
	  
	  <h3>Classe: Programador</h3>	     
	  <a class="nav-link" href="/programador/cadastro">Novo</a>            
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>CPF</th>
	        <th>Idade</th>
	        <th>Nome</th>
	        <th>Residencial</th>
	        <th>Sexo</th>
	        <th>Bebe Café</th>
	        <th>Linguagem</th>
	        <th>Sabe OO</th>
	        <th>#</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach var="b" items="${listagem}">
		      <tr>
		        <td>${b.id}</td>
		        <td>${b.idade}</td>
		        <td>${b.nome}</td>
		        <td>${b.residencial}</td>
		        <td>${b.sexo}</td>
		        <td>${b.bebecafe}</td>
		        <td>${b.linguagem}</td>
		        <td>${b.sabeoo}</td>
		        <td><a href="/programador/${b.id}/excluir">excluir</a></td>
		      </tr>	      
	      </c:forEach>     
	    </tbody>
	  </table>
	  
	</div>	
</body>
</html>
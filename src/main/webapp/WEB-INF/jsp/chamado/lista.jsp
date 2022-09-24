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
	  
	  <h3>Classe: Chamado</h3>	          
	  <a class="nav-link" href="/chamado/cadastro">Novo</a>    
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Código</th>
	        <th>DataIni</th>
	        <th>DataFim</th>
	        <th>Problema</th>
	        <th>Solução</th>
	        <th>Cliente</th>
	        <th>#</th>
	      </tr>
	    </thead>
	    <tbody>
	      <c:forEach var="b" items="${listagem}">
		      <tr>
		        <td>${b.id}</td>
		        <td>${b.dataini}</td>
		        <td>${b.datafim}</td>
		        <td>${b.problema}</td>
		        <td>${b.solucao}</td>
		        <td>${b.cliente.getNome()}</td>
		        <td><a href="/chamado/${b.id}/excluir">excluir</a></td>
		      </tr>
		   </c:forEach>	      
	      	      
	    </tbody>
	  </table>
	  
	</div>	
</body>
</html>
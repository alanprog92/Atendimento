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

<h1>Cadastro de Chamados</h1>

<form action="/chamado/cadastro" method="post">
  
  <div class="mb-3 mt-3">
    <label for="dataini" class="form-label">Data Ini.:</label>
    <input type="text" class="form-control" id="dataini" placeholder="Enter Data no formato DD/MM/AAAA" name="dataini">
  </div>
  
  <div class="mb-3 mt-3">
    <label for="datafim" class="form-label">Data Fim:</label>
    <input type="text" class="form-control" id="datafim" placeholder="Enter Data no formato DD/MM/AAAA" name="datafim">
  </div>
  
  <div class="mb-3 mt-3">
    <label for="problema" class="form-label">Problema:</label>
    <input type="text" class="form-control" id="problema" placeholder="Enter problema" name="problema">
  </div>
  
  <div class="mb-3 mt-3">
    <label for="solucao" class="form-label">Solução:</label>
    <input type="text" class="form-control" id="solucao" placeholder="Enter solucao" name="solucao">
  </div>  
  
  <div class="mb-3">
  	<label for="cliente" class="form-label">Cliente:</label>
	<select id="cliente" name="cliente" class="form-select">
	  <c:forEach var="cliente" items="${clientes}">
	 	 <option value="${ cliente.id }">${ cliente.nome }</option>
	  </c:forEach>
	</select>  
  </div>  
	  
	<c:forEach var="profissional" items="${profissionais}">
		<div class="form-check">
		  <input class="form-check-input" type="checkbox" value="${ profissional.id }" name="profissionais">
		  <label class="form-check-label">
		    ${ profissional.nome }
		  </label>
		</div>  
	</c:forEach>

    
  <button type="submit" class="btn btn-primary">Salvar</button>
  
</form>

</body>
</html>
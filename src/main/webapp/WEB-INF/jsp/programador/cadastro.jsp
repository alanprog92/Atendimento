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

<h1>Cadastro de Programador</h1>

<form action="/programador/cadastro" method="post">

  <c:import url="/WEB-INF/jsp/profissional.jsp"/>
    
  <div class="mb-3">    
  	<label for="cep" class="form-label">Bebe Café:</label>
	<select name="bebecafe" class="form-select">
	  <option value="S">S</option>
	  <option value="N">N</option>
	</select> 	    
  </div>
    
  <div class="mb-3">
    <label for="idade" class="form-label">Linguagem:</label>
    <input type="text" class="form-control" id="linguagem" placeholder="Enter linguagem" name="linguagem">
  </div>
  
  <div class="mb-3">    
  	<label for="cep" class="form-label">Sabe POO:</label>
	<select name="sabeoo" class="form-select">
	  <option value="S">S</option>
	  <option value="N">N</option>
	</select> 	    
  </div>    
    
  <button type="submit" class="btn btn-primary">Salvar</button>
  
</form>

</body>
</html>
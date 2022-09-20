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

<h1>Cadastro de Comercial</h1>

<form action="/comercial/cadastro" method="post">

  <c:import url="/WEB-INF/jsp/profissional.jsp"/>
    
  <div class="mb-3">    
  	<label for="cep" class="form-label">Bom de Venda:</label>
	<select name="bomdevenda" class="form-select">
	  <option value="S">S</option>
	  <option value="N">N</option>
	</select> 	    
  </div>
  
  <div class="mb-3">
    <label for="dtultmavenda" class="form-label">Dt. última Venda:</label>
    <input type="text" class="form-control" id="dtultmavenda" placeholder="Enter com o formato DD/MM/AAAA" name="dtultmavenda">
  </div> 
  
  <div class="mb-3">
    <label for="metamensal" class="form-label">Meta Mensal:</label>
    <input type="number" class="form-control" id="metamensal" placeholder="Enter meta mensal" name="metamensal">
  </div>  
  
    
  <button type="submit" class="btn btn-primary">Salvar</button>
  
</form>

</body>
</html>
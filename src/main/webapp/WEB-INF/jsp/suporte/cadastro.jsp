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

<h1>Cadastro de Suporte</h1>

<form action="/suporte/cadastro" method="post">

  <c:import url="/WEB-INF/jsp/profissional.jsp"/>
    
  <div class="mb-3">    
  	<label for="sabeformatar" class="form-label">Sabe Formatar:</label>
	<select name="sabeformatar" class="form-select">
	  <option value="S">S</option>
	  <option value="N">N</option>
	</select> 	    
  </div>
    
  <div class="mb-3">
    <label for="sopreferido" class="form-label">S.O. Preferido:</label>
    <input type="text" class="form-control" id="sopreferido" placeholder="Enter sopreferido" name="sopreferido">
  </div>
  
  <div class="mb-3">    
  	<label for="saberedes" class="form-label">Sabe Redes:</label>
	<select name="saberedes" class="form-select">
	  <option value="S">S</option>
	  <option value="N">N</option>
	</select> 	    
  </div>    
    
  <button type="submit" class="btn btn-primary">Salvar</button>
  
</form>

</body>
</html>
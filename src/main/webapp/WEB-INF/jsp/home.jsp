<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
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
	  <p>Projeto de Gest�o de Atendimentos</p>
	  
	  <h3>Classe: Chamado</h3>	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descri��o</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>codigo</td>
	        <td>int</td>
	        <td>C�digo do Chamado</td>
	      </tr>
	      <tr>
	        <td>dataini</td>
	        <td>LocalDate</td>
	        <td>Data in�cio do Chamado</td>
	      </tr>
	      <tr>
	        <td>datafim</td>
	        <td>LocalDate</td>
	        <td>Data fim do Chamado</td>
	      </tr>
	        <td>problema</td>
	        <td>String</td>
	        <td>Problema do Chamado</td>
	      </tr>	      
	      </tr>
	        <td>solucao</td>
	        <td>String</td>
	        <td>Solu��o do Chamado</td>
	      </tr>	 	      
	    </tbody>
	  </table>

	  <h3>Classe: Clientes</h3>	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descri��o</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>cpf</td>
	        <td>long</td>
	        <td>CPF do Cliente</td>
	      </tr>
	      <tr>
	        <td>idade</td>
	        <td>int</td>
	        <td>Idade do Cliente</td>
	      </tr>
	      <tr>
	        <td>nome</td>
	        <td>String</td>
	        <td>Nome do Cliente</td>
	      </tr>	      
	      <tr>
	        <td>residencial</td>
	        <td>Endereco</td>
	        <td>Endere�o do Cliente</td>
	      </tr>
	      <tr>
	        <td>sexo</td>
	        <td>char</td>
	        <td>Sexo do Cliente</td>
	      </tr>	      
	    </tbody>
	  </table>
	  
	  <h3>Classe: Comercial</h3>	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descri��o</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>bomdevenda</td>
	        <td>char</td>
	        <td>Se o Comercial � bom p/ vender</td>
	      </tr>
	      <tr>
	        <td>dtultimavenda</td>
	        <td>LocalDate</td>
	        <td>Data da �ltima venda</td>
	      </tr>
	      <tr>
	        <td>metamensal</td>
	        <td>double</td>
	        <td>Meta mensal do Comercial</td>
	      </tr>	           
	    </tbody>
	  </table>	  
	  
	  <h3>Classe: Endereco</h3>	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descri��o</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>bairro</td>
	        <td>String</td>
	        <td>Bairro do Endere�o</td>
	      </tr>
	      <tr>
	        <td>cep</td>
	        <td>int</td>
	        <td>CEP do Endere�o</td>
	      </tr>
	      <tr>
	        <td>cidade</td>
	        <td>String</td>
	        <td>Cidade do Endere�o</td>
	      </tr>	     
	      <tr>
	        <td>complemento</td>
	        <td>String</td>
	        <td>Complemento do Endere�o</td>
	      </tr>	
	      <tr>
	        <td>estado</td>
	        <td>String</td>
	        <td>Estado do Endere�o</td>
	      </tr>		      	      
	      <tr>
	        <td>logradouro</td>
	        <td>String</td>
	        <td>Logradouro do Endere�o</td>
	      </tr>	
	      <tr>
	        <td>numero</td>
	        <td>int</td>
	        <td>Numero do Endere�o</td>
	      </tr>		      	            
	    </tbody>
	  </table>		  
	  
	  <h3>Classe: Profissional</h3>	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descri��o</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>cpf</td>
	        <td>long</td>
	        <td>CPF do Profissional</td>
	      </tr>
	      <tr>
	        <td>idade</td>
	        <td>int</td>
	        <td>Idade do Profissional</td>
	      </tr>
	      <tr>
	        <td>nome</td>
	        <td>String</td>
	        <td>Nome do Profissional</td>
	      </tr>	     
	      <tr>
	        <td>residencial</td>
	        <td>Endereco</td>
	        <td>Endere�o do Profissional</td>
	      </tr>	
	      <tr>
	        <td>sexo</td>
	        <td>char</td>
	        <td>Sexo do Profissional</td>
	      </tr>		      	      
	    </tbody>
	  </table>		 
	  
	  <h3>Classe: Programador</h3>	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descri��o</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>bebecafe</td>
	        <td>char</td>
	        <td>Se o programador bebe caf�</td>
	      </tr>
	      <tr>
	        <td>linguagem</td>
	        <td>String</td>
	        <td>Linguagem de programa��o que o programador programa</td>
	      </tr>
	      <tr>
	        <td>sabeoo</td>
	        <td>char</td>
	        <td>Se o programador sabe orienta��o a objetos</td>
	      </tr>	           
	    </tbody>
	  </table>	  
	   
	   
	  <h3>Classe: Suporte</h3>	              
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descri��o</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>sabeformatar</td>
	        <td>char</td>
	        <td>Se a pessoa do suporte sabe formatar</td>
	      </tr>
	      <tr>
	        <td>saberedes</td>
	        <td>char</td>
	        <td>Se a pessoa do suporte sabe redes</td>
	      </tr>
	      <tr>
	        <td>sopreferido</td>
	        <td>String</td>
	        <td>Qual o sistema operacional preferido</td>
	      </tr>	           
	    </tbody>
	  </table>	  	   
	  
	</div>	
</body>
</html>
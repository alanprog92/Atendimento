<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

	<nav class="navbar navbar-expand-sm bg-light">
	
	  <div class="container-fluid">
	    <!-- Links -->
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="/">Home</a>
	      </li>	    
	      
	      <c:if test="${not empty user}">
		      
		      <li class="nav-item">
		        <a class="nav-link" href="/chamado/lista">Chamado</a>
		      </li>
		      
		      <li class="nav-item">
		        <a class="nav-link" href="/clientes/lista">Clientes</a>
		      </li>
		      
		      <li class="nav-item">
		        <a class="nav-link" href="/comercial/lista">Comercial</a>
		      </li>
		      
		      <li class="nav-item">
		        <a class="nav-link" href="/programador/lista">Programador</a>
		      </li>
		      
		      <li class="nav-item">
		        <a class="nav-link" href="/suporte/lista">Suporte</a>
		      </li>      	   
		      
		      <li class="nav-item">
		        <a class="nav-link" href="/usuario/lista">Usuarios</a>
		      </li>
		         
	    </c:if>		           	      
		</ul>
	    
	    <ul  class="navbar-nav">
	    
	    <c:if test="${empty user}"> 
			<li class="nav-item">
			   <a class="nav-link" href="/usuario/cadastro">Signup</a>
			</li>
		</c:if>
	        	   
	    <c:if test="${empty user}"> 
	      <li class="nav-item">
	        <a class="nav-link" href="/login">Login</a>
	      </li>
	    </c:if>
	        
	     <c:if test="${not empty user}">
		      <li class="nav-item">
		        <a class="nav-link" href="/logout">Logout  ${ user.nome }</a>
		      </li>
	      </c:if>        	      	    
	        	      	    
	    </ul>
	    
	  </div>
	
	</nav>
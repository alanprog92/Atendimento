<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

  <div class="mb-3 mt-3">
    <label for="nome" class="form-label">Nome:</label>
    <input type="text" class="form-control" id="nome" placeholder="Enter Name" name="nome">
  </div>

  <div class="mb-3 mt-3">
    <label for="cpf" class="form-label">CPF:</label>
    <input type="text" class="form-control" id="CPF" placeholder="Enter cpf" name="CPF">
  </div>
  
  <div class="mb-3">
    <label for="idade" class="form-label">Idade:</label>
    <input type="text" class="form-control" id="idade" placeholder="Enter idade" name="idade">
  </div>
  
  <div class="mb-3">
    <label for="cidade" class="form-label">Cidade:</label>
    <input type="text" class="form-control" id="residencial.cidade" placeholder="Enter cidade" name="residencial.cidade">
  </div>

  <div class="mb-3">
    <label for="cep" class="form-label">CEP:</label>
    <input type="text" class="form-control" id="residencial.CEP" placeholder="Enter cep" name="residencial.CEP">
  </div>
	  
  <div class="mb-3">
  	<label for="cep" class="form-label">Sexo:</label>
	<select name="sexo" class="form-select">
	  <option value="M">M</option>
	  <option value="F">F</option>
	</select>  
  </div>

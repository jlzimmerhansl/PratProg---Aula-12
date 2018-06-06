<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >

<html lang="pt-br">


<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE-edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Cadastro de Países</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Nunito" rel="stylesheet">
</head>


<body>

	<!-- Menu superior -->
		<c:import url="Menu.jsp"/>
		
		<!-- container principal -->
	<div id="main" class="container">
	


	<div class="page-header">
  <h1>Cadastro de País </h1>
</div>
	<form action="controller.do" method="post">
	
	
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-2 col-form-label">País</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="nome" id="inputEmail3" placeholder="Digite um País">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Populaçao</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="populacao" id="inputPassword3" placeholder="Digite a População">
    </div>
  </div>
  
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Área</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="area" id="inputPassword3" placeholder="Digite a População">
    </div>
  </div>
  
    <div class="form-group row">
    <label for="inputPassword3" class="col-sm-2 col-form-label">Continente</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" name="continente" id="inputPassword3" placeholder="Digite o Continente">
    </div>
  </div>
     
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-info" name="command" value="CriarPais">Salvar Informações</button>
      
       <a href="index.jsp" class="btn btn-info">Cancelar</a>
       
      
    </div>
  </div>

</form>
</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
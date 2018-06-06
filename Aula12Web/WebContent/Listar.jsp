<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >

<html lang="pt-br">


<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cadastro de Países</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nunito"
	rel="stylesheet">
</head>


<body>


            
            
	<!-- Menu superior -->
	<c:import url="Menu.jsp" />

	<!-- container principal -->
	<div id="main" class="container">
	
	<form action="controller.do" method="get">

		<h2>Veja todos os Países cadastrados!!!</h2>
		<br>

		<div class="form-group row">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-info" name="command"
					value="ListarPais">Listar Países</button>

				


			</div>
		</div>
		
		<br><br>

		<h2>Busque um Continente!!!</h2>
		<br>

		<form class="form-inline">
			
			<div class="form-group mx-sm-6 mb-2">
					<input class="form-control mr-sm-2" name = continente type=text placeholder="Digite um Continente" aria-label="buscar">
			</div>
			<button type="submit" class="btn btn-info mb-2" name="command"
					value="BuscarContinente">Buscar Continente</button>
		</form>
		
		
		
		

</form>
	</div>
	
	
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	

</body>
</html>
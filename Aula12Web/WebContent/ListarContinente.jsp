<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="model.Pais, java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Listar Continente</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
</head>


<body>


<!-- Menu superior -->
	
	<c:import url="Menu.jsp"/>
	
	  
	<div id="main" class="container">
	
		<h3 class="page-header">Listar Continentes</h3>
		
		<c:forEach var="continente" items="${continentelist}">
		
		<div class="row">
                <div class="col-md-12">
                    <p><strong>Id:</strong>  ${continente.id} |
                    <strong>Nome:</strong>  ${continente.nome} |
                    <strong>Populacao:</strong>  ${continente.populacao} |
                    <strong>Area:</strong>  ${continente.area} |
                    <strong>Continente:</strong>  ${continente.continente}  </p>
                   
                </div> 
                
                </div>
                
                
          	
	</c:forEach>
	
	</div>
	
</body>
</html>
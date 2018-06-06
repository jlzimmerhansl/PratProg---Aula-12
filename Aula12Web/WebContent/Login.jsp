<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >

<html lang="pt-br">


<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE-edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Nunito" rel="stylesheet">
</head>

<body>

	<!-- Menu superior -->
		<c:import url="Menu.jsp"/>
		
		<!-- container principal -->
	<div id="main" class="container">
	
	<form action="controller.do" method="post">


	 <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Login</div>
                        
                    </div> 
                    
                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form id="loginform" class="form-horizontal" role="form">
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input type="text" class="form-control" name = "username" id="username" placeholder="Username" required>                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input type="password" class="form-control" name = "password" id="password" placeholder="Password" required>
                                    </div>


			 <div class="form-group row">
    			<div class="col-sm-10">
      			<button type="submit" class="btn btn-info" name="command" value="Login">Login</button>
      
    			   <a href="index.jsp" class="btn btn-info">Cancelar</a>
       
      
  		  </div>
 		 </div>

</form>
</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
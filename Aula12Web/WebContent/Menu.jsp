<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- barra de menu -->



<nav class="navbar-default navbar-static-top">
	
        <div class="container-fluid">


            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Página Inicial</a>
            </div>
            
            <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Cadastro.jsp">Cadastro de País</a>
            </div>
            
            
            <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Listar.jsp">Listar Países</a>
            </div>
            
             <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="GerenciarPaises.jsp">Gerenciar Pais</a>
            </div>
            
             <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="CadastrarUsuario.jsp">Cadastre - se</a>
            </div>
            
            <c:choose>
		<c:when test="${mensagem eq 'Sim' }">
		
			<form class="form-inline" action="controller.do" method="get">
            <span class="navbar-text">
    				Bem - vindo (a): ${logado.username }
    				
    			<button type="submit"  name = "command" value="Logout">logout</button>
    				
  			</span>
         </form>
		</c:when>
		
		<c:otherwise>
		
			<div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="Login.jsp">Login</a>
            </div>
		
		</c:otherwise>
	</c:choose>
         
            
             <div class="container-fluid">
            
            <div id="navbar" class="navbar-collapse collapse navbar-right">
            
            <form class="form-inline" action="controller.do" method="get">
				<input class="form-control mr-sm-2" name = "nome" type=text placeholder="Digite um País" aria-label="buscar">
				<button type="submit" class="btn btn-info my-2 my-sm-0"  name = "command" value="Buscar">Buscar País</button>
				
				
			</form>
			</div>
               
            </div>
        </div>
        
    </nav>	


	


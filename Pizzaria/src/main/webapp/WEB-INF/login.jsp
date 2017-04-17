<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Pizzaria - Login</title>
	<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
	<style type="text/css">
		@IMPORT url("${path}/static/bootstrap-3.3.6/css/bootstrap.min.css");
		@IMPORT url("${path}/static/bootstrap-3.3.6/css/bootstrap-theme.min.css");
	</style>
	</head>
	<body>
	    
	    <section id="login" class="panel panel-primary">
	    	<form action="${path}/autenticar" method="post">
		    	<div class="panel-heading">
		    		Pizzaria - Login
		    	</div>
		    	<div class="panel-body">
			    	<label for="usuario"></label>
			    	<input id="usuario" name="usuario" class="form-control">
			    	
			    	<label for="senha"></label>
			    	<input type="password" id="senha" name="senha" class="form-control">
			    	
			    	<button id="btn-login" class="btn btn-primary">Entrar</button>
		    	</div>
	    	</form>
	    </section>
	    		
		<script type="text/javascript" src="${path}/static/js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="${path}/static/bootstrap-3.3.6/js/bootstrap.min.js"></script>
		
	</body>
</html>
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
	#btn-sair{
		margin-top: 7px;
	}
</style>
</head>
<body>
    <nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">Pizzaria</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	
	      </ul>

	      <ul class="nav navbar-nav navbar-right">
	        <li>
				<form action="${path}/sair" method="post">
					<input type="hidden" name="_csrf" value="${_csrf.token}">
					<button id="btn-sair" type="submit" class="btn btn-default">Sair da aplicação</button>
				</form>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
	<script type="text/javascript" src="${path}/static/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="${path}/static/bootstrap-3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
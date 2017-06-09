<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Busca Pizza</title>
	<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
	<style type="text/css">
		@IMPORT url("${path}/static/bootstrap-3.3.6/css/bootstrap.min.css");
		@IMPORT	url("${path}/static/bootstrap-3.3.6/css/bootstrap-theme.min.css");
		@IMPORT	url("${path}/static/css/main.css");
	</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../menu-cliente.jsp" />
	
		<section>
			<div id="consulta-pizzarias" class="well">
				<div class="row">
					<div class="col-sm-4">
						<label for="pizza_pesquisa">Que pizza você quer hoje?</label> 
						<select id="pizza_pesquisa" class="form-control">
							<c:forEach items="${pizzasLista}" var="pizza">
								<option value="${pizza.id}">${pizza.nome}</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-sm-4">
						<button id="btn-buscar" class="btn btn-primary">Buscar pizzarias</button>
					</div>
				</div>
			</div>
			<div id="secao-pizzarias"></div>
		</section>
	</div>
	<script type="text/javascript" src="${path}/static/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="${path}/static/bootstrap-3.3.6/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path}/static/js/pizzaria.js"></script>
</body>
</html>
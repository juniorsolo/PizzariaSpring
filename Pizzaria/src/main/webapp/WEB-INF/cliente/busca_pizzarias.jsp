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
	</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../menu-cliente.jsp" />
	
		<section>
			<div id="consulta-pizzarias" class="well">
				<label for="pizza_pesquisa">Que pizza você quer hoje?</label> <select
					class="form-control">
					<c:forEach items="${pizzasLista}" var="pizza">
						<option value="${pizza.id}">${pizza.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div id="secao-pizzarias"></div>
		</section>
	</div>
</body>
</html>
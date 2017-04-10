<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${titulo}</title>
	<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
	<style type="text/css">
		@IMPORT url("${path}/static/bootstrap-3.3.6/css/bootstrap.min.css");
		@IMPORT url("${path}/static/bootstrap-3.3.6/css/bootstrap-theme.min.css");
	</style>
	</head>
	<body>
	    <c:if test="${not empty mensagemErro}">
	    	<div class="container">
	    		<div class="alert alert-danger">${mensagemErro}</div>     
	    	</div>
	    </c:if>
	    <c:if test="${not empty mensageminfo}">
	    	<div class="container">
	    		<div class="alert alert-info">${mensageminfo}</div>     
	    	</div>
	    </c:if>
		<section class="container">
		    <table class="table table-hover table-condensed table-striped table-bordered">
		    	<thead>
		    		<tr>
		    			<td>ID</td>
		    			<td>Nome</td>
		    			<td>Categoria</td>
		    		</tr>
		    	</thead>
		    	<tbody>
		    	   <c:forEach items="${ingredientesLista}" var="ingrediente">
			    		<tr>
			    			<td>${ingrediente.id}</td>
			    			<td>${ingrediente.nome}</td>
			    			<td>${ingrediente.categoria}</td>
			    		</tr>
		    		</c:forEach>
		    	</tbody>
		    	<tfoot>
		    		<tr>
		    			<td colspan="3">Total de ingredientes: ${ingredientesLista.size()}</td>
		    		</tr>
		    		<tr>
		    			<td colspan="3">
		    				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modal-ingrediente">
		    					Cadastrar Ingrediente
		    				</button>
		    			</td>
		    		</tr>		    		
		    	</tfoot>		    	
		    </table>
		</section>
		<jsp:include page="modal-ingrediente.jsp" />
		<script type="text/javascript" src="${path}/static/js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="${path}/static/bootstrap-3.3.6/js/bootstrap.min.js"></script>
		
	</body>
</html>
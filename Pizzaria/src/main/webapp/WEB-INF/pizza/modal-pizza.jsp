<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-pizza" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-pizza" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title"><spring:message code="view.modal.pizza.titulo" /></h4>
				</div>
				<div class="modal-body">
					<label for="nome"><spring:message code="view.modal.pizza.nome"/>: </label> <input id="nome" name="nome"class="form-control">
					<label for="preco"><spring:message code="view.modal.pizza.preco" />: </label> <input id="preco" name="preco"class="form-control"> 
					<label for="tamanho"><spring:message code="view.modal.pizza.tamanho"/>:</label> 
					<select id="tamanho" name="tamanho" class="form-control">
						<c:forEach items="${tamanho}" var="tamanho">
							<option value="${tamanho}">${tamanho}</option>
						</c:forEach>
					</select> 
					<label for="ingredientes"><spring:message code="view.modal.pizza.ingredientes" /> :</label> 
					<select id="ingredientes" name="ingredientes" class="form-control" multiple="multiple">
						<c:forEach items="${ingredientesLista}" var="ingrediente">
							<option value="${ingrediente.id}">${ingrediente.nome}</option>
						</c:forEach>
					</select> 
					<input id="id" name="id" type="hidden"> 
					<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="view.modal.pizza.cancelar" /></button>
					<button id="btn-salvar" type="button" class="btn btn-primary"><spring:message code="view.modal.pizza.salvar" /></button>
				</div>
			</form>
		</div>
	</div>
</div>
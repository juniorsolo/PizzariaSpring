<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="modal fade" id="modal-ingrediente" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-ingrediente" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title"><spring:message code="view.modal.ingrediente.titulo"/></h4>
				</div>
				<div class="modal-body">
					<label for="nome"><spring:message code="view.modal.ingrediente.nome"/>:</label><input id="nome" name="nome"class="form-control"> 
					<label for="categoria"><spring:message code="view.modal.ingrediente.categoria"/>:</label> 
						<select id="categoria" name="categoria" class="form-control">
							<c:forEach items="${categorias}" var="categoria">
								<option value="${categoria}">${categoria}</option>
							</c:forEach>
						</select> 
						<input id="id" name="id" type="hidden"> 
						<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="view.modal.ingrediente.cancelar"/></button>
					<button id="btn-salvar" type="button" class="btn btn-primary"><spring:message code="view.modal.ingrediente.salvar"/></button>
				</div>
			</form>
		</div>
	</div>
</div>
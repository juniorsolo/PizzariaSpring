<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<fmt:setLocale value="pt_BR" />
<table class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<td style="width:10%">#</td>
			<td style="width:20%"><spring:message code="view.tabela.pizza.nome" /></td>
			<td style="width:10%"><spring:message code="view.tabela.pizza.preco" /></td>
			<td style="width:10%"><spring:message code="view.tabela.pizza.tamanho" /></td>
			<td style="width:30%"><spring:message code="view.tabela.pizza.ingredientes"/></td>
			<td style="width:10%"><spring:message code="view.tabela.pizza.editar"/></td>
			<td style="width:10%"><spring:message code="view.tabela.pizza.deletar"/></td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pizzasLista}" var="pizza">
			<tr data-id="${pizza.id}">
				<td>${pizza.id}</td>
				<td>${pizza.nome}</td>
				<td>					
					<fmt:formatNumber value="${pizza.preco}" type="currency"/>					
				</td>
				<td>${pizza.tamanho}</td>
				<td>
					<c:forEach items="${pizza.ingredientes}" var="ingrediente">
					    ${ingrediente.nome},
					</c:forEach>
				</td>
				<td style="text-align: center;"><button class="btn btn-warning btn-editar"><spring:message code="view.tabela.pizza.editar"/></button></td>
				<td style="text-align: center;"><button class="btn btn-danger btn-deletar"><spring:message code="view.tabela.pizza.deletar"/></button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7"><spring:message code="view.tabela.pizza.total"/>: <span id="quantidade-pizzas">${pizzasLista.size()}</span></td>
		</tr>
		<tr>
			<td colspan="7">
				<button id="salvar-pizza" type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-pizza"><spring:message code="view.tabela.pizza.cadastrar"/></button>
			</td>
		</tr>
	</tfoot>
</table>
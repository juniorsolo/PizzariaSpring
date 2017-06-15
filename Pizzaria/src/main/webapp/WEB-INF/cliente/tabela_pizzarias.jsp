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
			<td style="width:10%">Nome</td>
			<td style="width:30%">Endereco</td>
			<td style="width:20%">Atendendo desde</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pizzarias}" var="pizzaria">
			<tr>
				<td>${pizzaria.id}</td>
				<td>${pizzaria.nome}</td>
				<td>${pizzaria.endereco}</td>
				<td><fmt:formatDate value="${pizzaria.dataCadastro.time}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
			</tr>

		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">Pizzaria encontradas: <span id="quantidade-pizzarias">${pizzasLista.size()}</span></td>
		</tr>
		<tr>
			<td colspan="7">
				<button id="salvar-pizza" type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-pizza"><spring:message code="view.tabela.pizza.cadastrar"/></button>
			</td>
		</tr>
	</tfoot>
</table>
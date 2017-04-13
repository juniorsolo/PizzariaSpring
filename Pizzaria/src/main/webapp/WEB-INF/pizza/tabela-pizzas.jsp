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
			<td style="width:20%">Nome</td>
			<td style="width:10%">preco</td>
			<td style="width:10%">Tamanho</td>
			<td style="width:30%">Ingredientes</td>
			<td style="width:10%">Editar</td>
			<td style="width:10%">Deletar</td>
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
				<td style="text-align: center;"><button class="btn btn-warning btn-editar" >Editar</button></td>
				<td  style="text-align: center;"><button class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">Total de pizzas: <span id="quantidade-pizzas">${pizzasLista.size()}</span></td>
		</tr>
		<tr>
			<td colspan="7">
				<button id="salvar-pizza" type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-pizza">Cadastrar Pizza</button>
			</td>
		</tr>
	</tfoot>
</table>
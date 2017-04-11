<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<table class="table table-hover table-condensed table-striped table-bordered">
	<thead>
		<tr>
			<td style="width:10%">#</td>
			<td style="width:50%">Nome</td>
			<td style="width:20%">Categoria</td>
			<td style="width:10%">Editar</td>
			<td style="width:10%">Deletar</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ingredientesLista}" var="ingrediente">
			<tr data-id="${ingrediente.id}">
				<td>${ingrediente.id}</td>
				<td>${ingrediente.nome}</td>
				<td>${ingrediente.categoria}</td>
				<td style="text-align: center;"><button class="btn btn-warning btn-editar" >Editar</button></td>
				<td  style="text-align: center;"><button class="btn btn-danger btn-deletar">Deletar</button></td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5">Total de ingredientes: <span id="quantidade-ingredientes">${ingredientesLista.size()}</span></td>
		</tr>
		<tr>
			<td colspan="5">
				<button id="salvar-ingredientes" type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#modal-ingrediente">Cadastrar Ingrediente</button>
			</td>
		</tr>
	</tfoot>
</table>
/**
 * Criado para Ingredientes
 */

$(document).ready(function() {
   aplicarListeners();
   //Chamda somente uma vez,  para nao dar over listener
   salvarListerner();
});

var limparModal = function(){
	$("#id").val("");
	$("#nome").val("");
	$("#preco").val("");
	$("#tamanho").val("");
}

var aplicarListeners = function() {
	
	$("#modal-pizza").on('hide.bs.modal', limparModal);
	
	// Buscando pizza
	$(".btn-editar").on("click", function(){
		var tr = $(this).parents('tr');
		var id = tr.data('id');
		var url = "pizzas/"+id;
		
		$.get(url).success(function(pizza){
				$("#id").val(pizza.id);
				$("#nome").val(pizza.nome);
				$("#preco").val(pizza.preco);
				$("#tamanho").val(pizza.tamanho);
				$("#modal-pizza").modal('show');
			
		});
	});
	
	//Deletando elementos da lista
	$(".btn-deletar").on("click", function() {
		var tr = $(this).parents('tr');
		var id = tr.data('id');
		var quantidade = $("#quantidade-pizzas").text();
		var csrf = $("#csrf").val();
		
		$.ajax({
			url: "pizzas/"+id,
			type:'DELETE',
			headers: {"X-CSRF-TOKEN":csrf},
			success: function(result){
				tr.remove();
				$("#quantidade-pizzas").text(quantidade -1);
			}
		});
		
	});
		
}

var salvarListerner = function(){
	//Salvando elemento e atualizando lista
	$("#btn-salvar").on("click", function() {

		var formPizza = $("#form-pizza").serialize();
		var url = 'pizzas';

		$.post(url, formPizza).done(function(pagina) {
			$("#sessao-pizzas").html(pagina);
			aplicarListeners();

		}).fail(function() {
			alert('erro ao salvar');

		}).always(function() {
			$("#modal-pizza").modal('hide');
		});

	});
}
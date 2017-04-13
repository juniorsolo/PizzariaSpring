/**
 * Criado para Ingredientes
 */

$(document).ready(function() {
   aplicarListeners();
});

var limparModal = function(){
	$("#id").val("");
	$("#nome").val("");
	$("#preco").val("");
	$("#tamanho").val("");
}

var aplicarListeners = function() {
	
	$("#modal-pizza").on('hide.bs.modal', limparModal);
	
	
	//Deletando elementos da lista
	$(".btn-deletar").on("click", function() {
		var tr = $(this).parents('tr');
		var id = tr.data('id');
		var quantidade = $("#quantidade-pizzas").text();
		
		$.ajax({
			url: "pizzas/"+id,
			type:'DELETE',
			success: function(result){
				tr.remove();
				$("#quantidade-pizzas").text(quantidade -1);
			}
		});
		
	});
	
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
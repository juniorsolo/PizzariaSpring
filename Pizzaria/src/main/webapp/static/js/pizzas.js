/**
 * Criado para Ingredientes
 */

$(document).ready(function() {
   aplicarListeners();
});

var limparModal = function(){
	$("#id").val("");
	$("#nome").val("");
	$("#categoria").val("");
}

var aplicarListeners = function() {
	
	$("#modal-ingrediente").on('hide.bs.modal', limparModal);
	
	//Buscando ingrediente
	$(".btn-editar").on("click", function(){
		var tr = $(this).parents('tr');
		var id = tr.data('id');
		var url = "ingredientes/"+id;
		
		$.get(url).success(function(ingrediente){
			$("#id").val(ingrediente.id);
			$("#nome").val(ingrediente.nome);
			$("#categoria").val(ingrediente.categoria);
			
			$("#modal-ingrediente").modal('show');
		});
		
	});
	
	//Deletando elementos da lista
	$(".btn-deletar").on("click", function() {
		var tr = $(this).parents('tr');
		var id = tr.data('id');
		var quantidade = $("#quantidade-ingredientes").text();
		
		$.ajax({
			url: "ingredientes/"+id,
			type:'DELETE',
			success: function(result){
				tr.remove();
				$("#quantidade-ingredientes").text(quantidade -1);
			}
		});
		
	});
	
	//Salvando elemento e atualizando lista
	$("#btn-salvar").on("click", function() {

		var formIngrediente = $("#form-ingrediente").serialize();
		var url = 'ingredientes';

		$.post(url, formIngrediente).done(function(pagina) {
			$("#sessao-ingredientes").html(pagina);
			aplicarListeners();

		}).fail(function() {
			alert('erro ao salvar');

		}).always(function() {
			$("#modal-ingrediente").modal('hide');
		});

	});

	
}
/**
 * Criado para Ingredientes
 */

$(document).ready(function() {
   aplicarListeners();
});

var aplicarListeners = function() {
	
	//Deletando elementos da lista
	$(".btn-deletar").on("click", function() {
		var tr = $(this).parents('tr');
		var id = tr.data('id');
		
		$.ajax({
			url: "ingredientes/"+id,
			type:'DELETE',
			success: function(result){
				tr.remove();
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
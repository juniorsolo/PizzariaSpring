/**
 *  Criado para Ingredientes
 */

$(document).ready(function(){
	$("#btn-salvar").on("click", function(){
		
		var formIngrediente = $("#form-ingrediente").serialize();
		var url = 'ingredientes';
		
		$.post(url,formIngrediente).done(function(pagina){
			$("#sessao-ingredientes").html(pagina);
			
		}).fail(function(){
			alert('erro ao salvar');
			
		}).always(function(){
			$("#modal-ingrediente").modal('hide');
		});
		
		
	});
	
});
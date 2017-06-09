
var buscar = function(){
   var url = '/pizzaria/pizza/' + nomePizza;
   var nomePizza = $("#pizza_pesquisa").val();
	
   $.get(url).success(function(view){
	   $("#secao-pizzarias").html(view);
   });
   
}


$(document).ready(function(){
	$("#btn-buscar").on('click', buscar);
});
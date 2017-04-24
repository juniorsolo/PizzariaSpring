package br.com.junior.pizzaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.junior.pizzaria.exception.IngredienteInvalidException;
import br.com.junior.pizzaria.modelo.entidade.Ingrediente;
import br.com.junior.pizzaria.modelo.enun.CategoriaIngrediente;
import br.com.junior.pizzaria.modelo.repositorio.IngredienteRepositorio;
import br.com.junior.pizzaria.modelo.servico.ServicoIngrediente;
import br.com.junior.pizzaria.modelo.servico.ServicoPizzaria;

@Controller
//@RestController  Todos os metodos ficam responseBody
@RequestMapping("/ingredientes")
public class IngredienteController {
	
	@Autowired private ServicoIngrediente servicoIngrediente;

	@RequestMapping(method=RequestMethod.GET)
	public String listarIngredientes(Model model ){
		Iterable<Ingrediente> ingredientes = servicoIngrediente.listar();
		
		model.addAttribute("titulo", "Listagem de ingredientes - Pizza");
		model.addAttribute("ingredientesLista", ingredientes);
		model.addAttribute("categorias", CategoriaIngrediente.values());
		
		return "ingrediente/listagem";
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarIngrediente(@Valid @ModelAttribute Ingrediente ingrediente, 
			BindingResult bindingResult, 
			Model model){
		if(!bindingResult.hasErrors()){
			servicoIngrediente.salvar(ingrediente);

		}else{
			throw new IngredienteInvalidException();
		}
		
		model.addAttribute("ingredientesLista", servicoIngrediente.listar());
		model.addAttribute("categorias", CategoriaIngrediente.values());
		return "ingrediente/tabela-ingredientes";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarIngrediente(@PathVariable Long id){
		try{
			servicoIngrediente.Remover(id); 
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Ingrediente buscarIngrediente(@PathVariable Long id){
		Ingrediente ingrediente = servicoIngrediente.buscar(id);
		return ingrediente;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

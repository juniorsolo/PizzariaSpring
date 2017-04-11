package br.com.junior.pizzaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.junior.pizzaria.exception.IngredienteInvalidException;
import br.com.junior.pizzaria.modelo.entidade.Ingrediente;
import br.com.junior.pizzaria.modelo.enun.CategoriaIngrediente;
import br.com.junior.pizzaria.modelo.repositorio.IngredienteRepositorio;

// Metodo GET lista os ingredientes
// Metodo POST salva o ingrediente

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController {
	
	@Autowired private IngredienteRepositorio ingredienteRepo;
	
	@RequestMapping(method=RequestMethod.GET)
	public String listarIngredientes(Model model ){
		Iterable<Ingrediente> ingredientes = ingredienteRepo.findAll();
		
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
			ingredienteRepo.save(ingrediente);

		}else{
			throw new IngredienteInvalidException();
		}
		
		model.addAttribute("ingredientesLista", ingredienteRepo.findAll());
		model.addAttribute("categorias", CategoriaIngrediente.values());
		return "ingrediente/tabela-ingredientes";
	}
}

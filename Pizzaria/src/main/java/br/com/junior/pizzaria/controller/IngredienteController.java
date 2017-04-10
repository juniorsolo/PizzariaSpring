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

import br.com.junior.pizzaria.modelo.entidade.Ingrediente;
import br.com.junior.pizzaria.modelo.enun.CategoriaIngrediente;
import br.com.junior.pizzaria.modelo.repositorio.IngredienteRepositorio;

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
	public String salvarIngrediente(@Valid @ModelAttribute Ingrediente ingrediente, BindingResult bindingResult, RedirectAttributes redirectAtributes){
		if(!bindingResult.hasErrors()){
			ingredienteRepo.save(ingrediente);
			redirectAtributes.addFlashAttribute("mensageminfo", "Ingrediente salvo com sucesso!");
		}else{
			FieldError error = bindingResult.getFieldErrors().get(0);
			redirectAtributes.addFlashAttribute("mensagemErro", "Erro ao salvar: " + error.getField() +"  "+  error.getDefaultMessage());
		}
		return "redirect:/app/ingredientes";
	}
}

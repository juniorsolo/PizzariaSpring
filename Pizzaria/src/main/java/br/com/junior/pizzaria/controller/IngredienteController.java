package br.com.junior.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.junior.pizzaria.modelo.entidade.Ingrediente;
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
		
		return "ingrediente/listagem";
	}
}

package br.com.junior.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.junior.pizzaria.modelo.servico.ServicoPizza;

@Controller
@RequestMapping("/pizzarias")
public class PizzariaController {
	
	@Autowired
	private ServicoPizza pizzaService;
	
	@RequestMapping(method=RequestMethod.GET) 
	public String index(Model model){
	      	
		model.addAttribute("pizzasLista", pizzaService.listarTodas());
		return "cliente/busca_pizzarias";
	}
}

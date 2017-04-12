package br.com.junior.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.junior.pizzaria.modelo.enun.TamanhoPizza;
import br.com.junior.pizzaria.modelo.repositorio.PizzaRepositorio;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private PizzaRepositorio pizzaRepo;

	@RequestMapping(method = RequestMethod.GET)
	public String listarPizzas(Model model) {

		model.addAttribute("tamanho", TamanhoPizza.values());
		model.addAttribute("pizzasLista", pizzaRepo.findAll());

		return "pizza/listagem";
	}


	
	public PizzaController() {
		System.out.println("criando pizzas controller.....");
	}

	@RequestMapping("/ola/{nome}")
	@ResponseBody
	public String ola(@PathVariable String nome) {
		return "Olá,  " + nome;
	}

	@RequestMapping("/numero")
	@ResponseBody
	public String qtd() {
		return "Existem " + pizzaRepo.count() + " pizzas cadastradas";
	}

}

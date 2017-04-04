package br.com.junior.pizzaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
    
	 public PizzaController() {
		System.out.println("criando pizzas controller.....");
	}
	
	@RequestMapping("/ola/{nome}")
	@ResponseBody
	public String ola(@PathVariable String nome){
		return "Olá,  " + nome;
	}
}

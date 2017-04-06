package br.com.junior.pizzaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.junior.pizzaria.modelo.repositorio.PizzaRepositorio;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
     
	 @Autowired private PizzaRepositorio pizza;
	 public PizzaController() {
		System.out.println("criando pizzas controller.....");
	}
	
	@RequestMapping("/ola/{nome}")
	@ResponseBody
	public String ola(@PathVariable String nome){
		return "Olá,  " + nome;
	}
	
	@RequestMapping("/numero")
	@ResponseBody
	public String qtd(){
		return "Existem "+ pizza.count()  +" pizzas cadastradas";
	}
}

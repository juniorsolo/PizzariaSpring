package br.com.junior.pizzaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.junior.pizzaria.exception.PizzaInvalidException;
import br.com.junior.pizzaria.modelo.entidade.Pizza;
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
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvarPizzas(Model model, @Valid @ModelAttribute Pizza pizza, 
			BindingResult bindResult){
		
		if(!bindResult.hasErrors()){
			pizzaRepo.save(pizza);
		}else{
			throw new PizzaInvalidException();
		}
		
		model.addAttribute("tamanho", TamanhoPizza.values());
		model.addAttribute("pizzasLista", pizzaRepo.findAll());
		
		return"pizza/tabela-pizzas";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarPizza(@PathVariable Long id){
		try {
			pizzaRepo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
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

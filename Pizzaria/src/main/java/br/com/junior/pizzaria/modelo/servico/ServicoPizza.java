package br.com.junior.pizzaria.modelo.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.junior.pizzaria.modelo.entidade.Pizza;
import br.com.junior.pizzaria.modelo.entidade.Pizzaria;
import br.com.junior.pizzaria.modelo.repositorio.PizzaRepositorio;

@Service
public class ServicoPizza {
	
	
	@Autowired
	private PizzaRepositorio repositorio;
	
	@Autowired
	private ServicoPizzaria servicoPizzaria;
	
	public void salvar(Pizza pizza){
		pizza.setDono(servicoPizzaria.getPizzariaLogada());
		repositorio.save(pizza);
	}
	
	public Iterable<Pizza> listar(){
		Pizzaria dono = servicoPizzaria.getPizzariaLogada();
		return repositorio.findAllByDono(dono);
	}
	
	public Pizza buscar(Long id){
		Pizzaria dono = servicoPizzaria.getPizzariaLogada();
		return repositorio.findByIdAndDono(id, dono);
	}
	
	public void Remover(Long id){
		Pizza pizza = this.buscar(id);
		
		if(pizza != null) repositorio.delete(pizza);
	}

	public List<Pizza> listarTodas() {
		
		return repositorio.findAll();
	}
	
}

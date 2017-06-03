package br.com.junior.pizzaria.modelo.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.junior.pizzaria.modelo.entidade.Ingrediente;
import br.com.junior.pizzaria.modelo.entidade.Pizzaria;
import br.com.junior.pizzaria.modelo.repositorio.IngredienteRepositorio;

@Service
public class ServicoIngrediente {
	
	
	@Autowired
	private IngredienteRepositorio repositorio;
	
	@Autowired
	private ServicoPizzaria servicoPizzaria;
	
	public void salvar(Ingrediente ingrediente){
		ingrediente.setDono(servicoPizzaria.getPizzariaLogada());
		repositorio.save(ingrediente);
	}
	
	public Iterable<Ingrediente> listar(){
		Pizzaria dono = servicoPizzaria.getPizzariaLogada();
		return repositorio.findAllByDono(dono);
	}
	
	public Ingrediente buscar(Long id){
		Pizzaria dono = servicoPizzaria.getPizzariaLogada();
		return repositorio.findByIdAndDono(id, dono);
	}
	
	public void remover(Long id){
		Ingrediente ingrediente = this.buscar(id);
		
		if(ingrediente != null) repositorio.delete(ingrediente);
	}
	
}

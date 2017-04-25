package br.com.junior.pizzaria.modelo.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.junior.pizzaria.modelo.entidade.Pizza;
import br.com.junior.pizzaria.modelo.entidade.Pizzaria;

@Repository
public interface PizzaRepositorio extends CrudRepository<Pizza, Long> {
   
	public List<Pizza> findAllByDono(Pizzaria dono);
	
	public Pizza findByIdAndDono(Long id, Pizzaria dono);
	
	public List<Pizza> findAll();
}

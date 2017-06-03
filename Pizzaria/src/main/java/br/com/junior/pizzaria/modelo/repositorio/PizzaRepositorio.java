package br.com.junior.pizzaria.modelo.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.junior.pizzaria.modelo.entidade.Pizza;
import br.com.junior.pizzaria.modelo.entidade.Pizzaria;

@Repository
public interface PizzaRepositorio extends CrudRepository<Pizza, Long> {
   
	List<Pizza> findAllByDono(Pizzaria dono);
	
	Pizza findByIdAndDono(Long id, Pizzaria dono);
	
	List<Pizza> findAll();
}

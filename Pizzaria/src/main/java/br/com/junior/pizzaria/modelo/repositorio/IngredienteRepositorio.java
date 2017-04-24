package br.com.junior.pizzaria.modelo.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.junior.pizzaria.modelo.entidade.Ingrediente;
import br.com.junior.pizzaria.modelo.entidade.Pizzaria;

@Repository
public interface IngredienteRepositorio extends CrudRepository<Ingrediente, Long>{
	
	public List<Ingrediente> findAllByDono(Pizzaria dono);
	
	public Ingrediente findByIdAndDono(Long id, Pizzaria dono);
	
}

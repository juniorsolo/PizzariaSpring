package br.com.junior.pizzaria.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.junior.pizzaria.modelo.entidade.Pizza;

@Repository
public interface PizzaRepositorio extends CrudRepository<Pizza, Long> {

}

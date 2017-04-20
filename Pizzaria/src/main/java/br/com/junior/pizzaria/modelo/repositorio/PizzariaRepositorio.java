package br.com.junior.pizzaria.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.junior.pizzaria.modelo.entidade.Pizzaria;

@Repository
public interface PizzariaRepositorio extends CrudRepository<Pizzaria, Long>{

	public Pizzaria findOneByLogin(String login);

}

package br.com.junior.pizzaria.modelo.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.junior.pizzaria.modelo.entidade.Pizzaria;
import br.com.junior.pizzaria.modelo.repositorio.PizzariaRepositorio;

@Service
public class ServicoPizzaria {
	
	@Autowired
	private PizzariaRepositorio pizzariaRepo;
	
	public Pizzaria getPizzariaLogada(){
		Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
		
		if(autenticado == null){
			throw new AuthenticationCredentialsNotFoundException("");
		}
		UserDetails pizzariaLogado = (UserDetails) autenticado.getPrincipal();
		return pizzariaRepo.findOneByLogin(pizzariaLogado.getUsername());
	}
}

package br.com.junior.pizzaria.modelo.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.junior.pizzaria.modelo.repositorio.PizzariaRepositorio;

@Service
public class AutenticacaoServico implements UserDetailsService{
	
	@Autowired
	private PizzariaRepositorio userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		return userRepo.findOneByLogin(login);
	}

}

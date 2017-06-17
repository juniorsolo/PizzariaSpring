package br.com.junior.pizzaria.modelo.entidade;

import javax.persistence.Embeddable;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Usuario {
   
	@NotNull @NotEmpty
	private String login;
	
	@NotNull @ NotEmpty
	private String senha;
	
	//Transiente nao grava na tabela
	@Transient
	@NotNull @ NotEmpty
	private String ConfirmarSenha;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return ConfirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		ConfirmarSenha = confirmarSenha;
	}	
	
	
}

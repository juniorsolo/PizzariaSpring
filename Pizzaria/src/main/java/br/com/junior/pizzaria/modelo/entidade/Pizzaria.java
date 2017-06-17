package br.com.junior.pizzaria.modelo.entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Pizzaria implements UserDetails{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Calendar dataCadastro;
	
	private Usuario usuario;

	private String nome;
	
	private String endereco;
	
	@ElementCollection
	private Set<String> email;
	
	@ElementCollection	
	private Set<String> telefone;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Permissao> permissoes;

	@OneToMany(mappedBy = "dono")
	private Set<Pizza> pizzas;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Set<String> getEmail() {
		return email;
	}

	public void setEmail(Set<String> email) {
		this.email = email;
	}

	public Set<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(Set<String> telefone) {
		this.telefone = telefone;
	}

	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	public Set<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getUsuario().getLogin() == null) ? 0 : getUsuario().getLogin().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizzaria other = (Pizzaria) obj;
		if (getUsuario().getLogin() == null) {
			if (other.getUsuario().getLogin() != null)
				return false;
		} else if (!getUsuario().getLogin().equals(other.getUsuario().getLogin()))
			return false;
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> autorizacoes = new ArrayList<>();
		
		for(Permissao permissao : getPermissoes()){
			autorizacoes.add(new SimpleGrantedAuthority(permissao.getNome()));
		}
		
		return autorizacoes;
	}

	@Override
	public String getPassword() {
		return getUsuario().getSenha();
	}

	@Override
	public String getUsername() {
		return getUsuario().getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	
	
	
}

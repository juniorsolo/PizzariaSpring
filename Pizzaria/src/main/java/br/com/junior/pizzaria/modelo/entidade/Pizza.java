package br.com.junior.pizzaria.modelo.entidade;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.junior.pizzaria.modelo.enun.TamanhoPizza;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String nome;
	
	@NotNull
	private Double preco;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TamanhoPizza tamanho;
	
	@ManyToMany
	private Set<Ingrediente> ingredientes;
	
		
	public Pizza(Long id, Double preco, TamanhoPizza tamanho, Set<Ingrediente> ingredientes) {
		super();
		this.id = id;
		this.preco = preco;
		this.tamanho = tamanho;
		this.ingredientes = ingredientes;
	}
	public Pizza() {		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public TamanhoPizza getTamanho() {
		return tamanho;
	}
	public void setTamanho(TamanhoPizza tamanho) {
		this.tamanho = tamanho;
	}
	public Set<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(Set<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tamanho == null) ? 0 : tamanho.hashCode());
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
		Pizza other = (Pizza) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tamanho != other.tamanho)
			return false;
		return true;
	}
    
	
	
	
}

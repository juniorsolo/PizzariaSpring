package br.com.junior.pizzaria.propertyeditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Component;

import br.com.junior.pizzaria.modelo.entidade.Ingrediente;
import br.com.junior.pizzaria.modelo.repositorio.IngredienteRepositorio;

@Component
public class IngredientePropertyEditor extends PropertiesEditor{
   
	@Autowired
	private IngredienteRepositorio ingredienteRepositorio;
	
	public void setAsText(String text){
		Long id = Long.parseLong(text);		
		Ingrediente ingrediente = ingredienteRepositorio.findOne(id);
		setValue(ingrediente);
	}
}

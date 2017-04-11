package br.com.junior.pizzaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class IngredienteInvalidException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3198276446051874108L;

}

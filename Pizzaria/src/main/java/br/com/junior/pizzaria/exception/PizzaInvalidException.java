package br.com.junior.pizzaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class PizzaInvalidException extends RuntimeException{
	
	private static final long serialVersionUID = -1521106540953707357L;

}

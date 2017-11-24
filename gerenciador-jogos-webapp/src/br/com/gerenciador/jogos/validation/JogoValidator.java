package br.com.gerenciador.jogos.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.gerenciador.jogos.domain.entities.Jogo;

public class JogoValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Jogo.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nome", "field.required");		
	}

}

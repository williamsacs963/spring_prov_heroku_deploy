package mx.uttt.edu.finalev.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsuarioRegexValidator implements ConstraintValidator<UsuarioRegex, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if(value.matches("[a-z-0-9]{6,10}")) {
			return true;
		}
		
		return false;
	}
	
}

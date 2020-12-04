package mx.uttt.edu.finalev.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordRegexValidator implements ConstraintValidator<PasswordRegex,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if(value.matches("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$")) {
			return true;
		}
		
		return false;
	}
	
}

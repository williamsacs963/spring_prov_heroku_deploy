package mx.uttt.edu.finalev.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailRegexValidator implements ConstraintValidator<EmailRegex, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if(value.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {
			return true;
		}
		
		return false;
	}
	
}

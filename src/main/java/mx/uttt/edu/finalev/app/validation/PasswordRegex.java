package mx.uttt.edu.finalev.app.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordRegexValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface PasswordRegex {

	String message() default "Debe contener entre 8-16 caracteres (entre numero, mayusculas, minusculas y simbolos)";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}

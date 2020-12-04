package mx.uttt.edu.finalev.app.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = UsuarioRegexValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface UsuarioRegex {

	String message() default "Debe contener entre 6-8 caracteres (solo numero y letras)";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}

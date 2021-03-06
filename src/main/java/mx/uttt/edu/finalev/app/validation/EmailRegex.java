package mx.uttt.edu.finalev.app.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = EmailRegexValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface EmailRegex {

	String message() default "Utilize una direccion de correo valida)";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	
}

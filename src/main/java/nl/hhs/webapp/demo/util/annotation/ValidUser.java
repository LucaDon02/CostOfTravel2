package nl.hhs.webapp.demo.util.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUser {

    String message() default "Invalid user";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

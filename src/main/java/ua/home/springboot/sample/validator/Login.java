package ua.home.springboot.sample.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LoginConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {
    String message() default "{Login}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

package ua.home.springboot.sample.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginConstraintValidator implements ConstraintValidator<Login, String> {

    @Override
    public void initialize(Login login) {
    }

    @Override
    public boolean isValid(String loginField, ConstraintValidatorContext cxt) {
        if (loginField == null) {
            return false;
        }
        return loginField.matches("[a-z\\.]*");
    }
}

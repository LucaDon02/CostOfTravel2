package nl.hhs.webapp.demo.service.validate;

import nl.hhs.webapp.demo.model.user.User;
import nl.hhs.webapp.demo.util.annotation.ValidUser;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidator implements ConstraintValidator<ValidUser, User> {

    @Override public void
    initialize( ValidUser constraintAnnotation ) {
        ConstraintValidator.super.initialize( constraintAnnotation );
    }

    @Override public boolean
    isValid( User user, ConstraintValidatorContext constraintValidatorContext ) {
        String err = errMsg( user );
        if ( err == null ) return true;

        constraintValidatorContext
            .buildConstraintViolationWithTemplate(err)
            .addConstraintViolation();
        return false;
    }

    private String
    errMsg( User user ) {
        if (! user.getPassword().equals(user.confirmationPassword) ) return "passwords do not match";
        return null;
    }
}

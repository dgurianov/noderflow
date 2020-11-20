package com.gud.noderflow.model.validators;

import com.gud.noderflow.model.attributes.users.UserEntityAttributes;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserEntityValidator implements ConstraintValidator<ValidUserEntity, UserEntityAttributes> {

    @Override
    public void initialize(ValidUserEntity constraintAnnotation) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public boolean isValid(UserEntityAttributes value, ConstraintValidatorContext context) {
        if(value.getFirstName().equalsIgnoreCase(value.getLastName())){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("First name and last name are the same!").addConstraintViolation();
            return false;
        }
        return true;
    }


}

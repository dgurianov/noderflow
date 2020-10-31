package com.gud.noderflow.model.validators;

import com.gud.noderflow.model.users.UserEntityAttributes;
import com.gud.noderflow.persistance.repository.UserContactsRepository;
import com.gud.noderflow.persistance.repository.UserPaymentDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserEntityValidator implements ConstraintValidator<ValidUserEntity, UserEntityAttributes> {

    @Autowired
    private UserContactsRepository contactsRepository;

    @Autowired
    private UserPaymentDataRepository paymentDataRepository;

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
        else if (isPhoneNumberAlreadyUsed(value.getContacts().getPhone())){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(String.format("Phone %s is already used.",value.getContacts().getPhone())).addConstraintViolation();
            return false;
        }else if (isAccountAlreadyUsed(value.getPaymentData().getAccountNumber())){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(String.format("Account number %s is already used.",value.getPaymentData().getAccountNumber())).addConstraintViolation();
            return false;
        }
        return true;
    }


    private boolean isPhoneNumberAlreadyUsed(String phoneNumber){
        return contactsRepository.findAlLWithPhoneNumber(phoneNumber).size() > 0;
    }

    private boolean isAccountAlreadyUsed(String accountNumber){
        return paymentDataRepository.getPaymentDataEntitiesWithAccount(accountNumber).size() > 0;
    }
}

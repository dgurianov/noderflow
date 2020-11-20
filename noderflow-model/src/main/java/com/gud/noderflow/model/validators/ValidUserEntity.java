package com.gud.noderflow.model.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = UserEntityValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ReportAsSingleViolation
public @interface ValidUserEntity {

    String message() default "Validation failed for UserEntityAttributes";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

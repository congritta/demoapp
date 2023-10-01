package com.example.demo.annotation;

import com.example.demo.validation.CustomValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CustomValidator.class)
@Documented
public @interface CustomConstraint {

    String message() default "This custom message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

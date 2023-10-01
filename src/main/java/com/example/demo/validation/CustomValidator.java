package com.example.demo.validation;

import com.example.demo.annotation.CustomConstraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CustomValidator implements ConstraintValidator<CustomConstraint, Object> {
    @Override
    public void initialize(CustomConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        String field = (String) value;
        return field.equals("custom");
    }
}

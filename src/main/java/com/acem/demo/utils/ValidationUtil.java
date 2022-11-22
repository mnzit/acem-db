package com.acem.demo.utils;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ValidationUtil {

    public static Optional<List<String>> validate(Object object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        List<String> violations = validator
                .validate(object)
                .stream()
                .map(constraintViolation -> constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage())
                .collect(Collectors.toList());

        return violations.isEmpty() ? Optional.empty() : Optional.of(violations);
    }
}

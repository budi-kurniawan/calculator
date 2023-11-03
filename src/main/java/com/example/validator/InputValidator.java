package com.example.validator;

import com.example.exception.InvalidInputException;

public interface InputValidator {
    void validate(String operand1, String operation, String operand2) throws InvalidInputException;
}

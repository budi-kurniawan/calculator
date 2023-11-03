package com.example.validator;

import com.example.exception.InvalidInputException;

public class InputValidator {
    private String operandPattern;
    private String operationPattern;
    
    public InputValidator(String operandPattern, String operationPattern) {
        this.operandPattern = operandPattern;
        this.operationPattern = operationPattern;
        
    }
    public void validate(String operand1, String operation, String operand2) throws InvalidInputException {
        if (operand1 == null || !operand1.matches(operandPattern)) {
            throw new InvalidInputException(operand1 + " is not a valid number.");
        }

        if (operation == null || !operation.matches(operationPattern)) {
            throw new InvalidInputException(operation + " is not a valid operation.");
        }

        if (operand2 == null || !operand2.matches(operandPattern)) {
            throw new InvalidInputException(operand2 + " is not a valid number.");
        }
    };
}

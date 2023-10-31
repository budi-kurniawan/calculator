package com.example;

import java.math.BigDecimal;

import com.example.exception.InvalidInputException;

public class Calculator {

    private static final String OPERAND_PATTERN = "[0-9]+[.]?[0-9]*";

    private static final String OPERATION_PATTERN = "[+|\\-|*|/]";

    public boolean isValidOperand(String s) {
        return s != null && s.matches(OPERAND_PATTERN);
    }

    public boolean isValidOperation(String s) {
        return s != null && s.matches(OPERATION_PATTERN);
    }

    public BigDecimal calculate(String input) throws InvalidInputException {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new InvalidInputException("Invalid input length.");
        }

        String operand1 = tokens[0];
        String operation = tokens[1];
        String operand2 = tokens[2];

        if (!isValidOperand(operand1)) {
            throw new InvalidInputException(operand1 + " is not a valid number");
        }

        if (!isValidOperation(operation)) {
            throw new InvalidInputException(operation + " is not a valid operation");
        }

        if (!isValidOperand(operand2)) {
            throw new InvalidInputException(operand2 + " is not a valid number");
        }

        BigDecimal op1 = new BigDecimal(operand1);
        BigDecimal op2 = new BigDecimal(operand2);
        BigDecimal result = switch (operation) {

        case "+" -> op1.add(op2);
        case "-" -> op1.subtract(op2);
        case "*" -> op1.multiply(op2);
        case "/" -> op1.divide(op2);
        default -> null;
        };

        System.out.println(input + " = " + result.toString());
        return result;
    }
}
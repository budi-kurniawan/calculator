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
        case "+" -> (new Context(new AdditionStrategy())).executeStrategy(op1, op2);
        case "-" -> (new Context(new SubtractionStrategy())).executeStrategy(op1, op2);
        case "*" -> (new Context(new MultiplicationStrategy())).executeStrategy(op1, op2);
        case "/" -> (new Context(new DivisionStrategy())).executeStrategy(op1, op2);
        default -> null;
        };

        System.out.println(input + " = " + result.toString());
        return result;
    }
}
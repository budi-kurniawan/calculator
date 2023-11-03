package com.example.parser;

import com.example.exception.InvalidInputException;

public class InputParser {
    
    public ParseResult parse(String input) throws InvalidInputException {
        String[] tokens = input.split(" ");
        if (tokens.length != 3) {
            throw new InvalidInputException("Invalid input length.");
        }
        String operand1 = tokens[0];
        String operation = tokens[1];
        String operand2 = tokens[2];
        return new ParseResult(operand1, operation, operand2);
    }
}

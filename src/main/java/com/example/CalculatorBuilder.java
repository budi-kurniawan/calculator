package com.example;

import java.util.HashMap;
import java.util.Map;

import com.example.algorithm.AdditionStrategy;
import com.example.algorithm.Context;
import com.example.algorithm.DivisionStrategy;
import com.example.algorithm.MultiplicationStrategy;
import com.example.algorithm.SubtractionStrategy;
import com.example.parser.InputParser;
import com.example.validator.InputValidator;

public class CalculatorBuilder {
    
    public static final String OPERAND_PATTERN = "[0-9]+[.]?[0-9]*";
    public static final String OPERATION_PATTERN = "[+|\\-|*|/]";

    public static Calculator build() {
        InputParser inputParser = new InputParser();
        InputValidator inputValidator = new InputValidator(OPERAND_PATTERN, OPERATION_PATTERN);
        Map<String, Context> contextMap = new HashMap<>();
        contextMap.put("+", new Context(new AdditionStrategy()));
        contextMap.put("-", new Context(new SubtractionStrategy()));
        contextMap.put("*", new Context(new MultiplicationStrategy()));
        contextMap.put("/", new Context(new DivisionStrategy()));
        return new Calculator(inputParser, inputValidator, contextMap);
    }
}

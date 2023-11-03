package com.example;

import java.math.BigDecimal;
import java.util.Map;

import com.example.algorithm.Context;
import com.example.exception.AlgorithmNotFoundException;
import com.example.exception.InvalidInputException;
import com.example.parser.InputParser;
import com.example.parser.ParseResult;
import com.example.validator.InputValidator;

public class Calculator {

    private InputParser inputParser;
    private InputValidator inputValidator;
    private Map<String, Context> contextMap;
    
    public Calculator(InputParser inputParser, InputValidator inputValidator, Map<String, Context> contextMap) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
        this.contextMap = contextMap;
    }

    public BigDecimal calculate(String input) throws InvalidInputException, AlgorithmNotFoundException {
        ParseResult parseResult = inputParser.parse(input);
        String operand1 = parseResult.operand1();
        String operation = parseResult.operation();
        String operand2 = parseResult.operand2();
        inputValidator.validate(operand1, operation, operand2);

        Context context = contextMap.get(operation);
        if (context == null) {
            throw new AlgorithmNotFoundException("Algorithm for operation " + operation + " is not found.");
        }
        BigDecimal result = context.executeStrategy(new BigDecimal(operand1), new BigDecimal(operand2));
        System.out.println(input + " = " + result.toString());
        return result;
    }
}
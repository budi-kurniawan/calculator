package com.example.algorithm;

import java.math.BigDecimal;

import com.example.exception.InvalidInputException;

public class Context {

    private CalculationStrategy strategy;
    
    public Context(CalculationStrategy strategy) {
        this.strategy = strategy;
    }
    
    public BigDecimal executeStrategy(BigDecimal operand1, BigDecimal operand2) throws InvalidInputException {
        return strategy.execute(operand1, operand2);
    }
    
}

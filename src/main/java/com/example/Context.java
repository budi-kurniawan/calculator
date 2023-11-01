package com.example;

import java.math.BigDecimal;

public class Context {

    private CalculationStrategy strategy;
    
    public Context(CalculationStrategy strategy) {
        this.strategy = strategy;
    }
    
    public BigDecimal executeStrategy(BigDecimal operand1, BigDecimal operand2) {
        return strategy.execute(operand1, operand2);
    }
    
}

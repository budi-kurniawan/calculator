package com.example.algorithm;

import java.math.BigDecimal;

public class MultiplicationStrategy implements CalculationStrategy {

    @Override
    public BigDecimal execute(BigDecimal operand1, BigDecimal operand2) {
        return operand1.multiply(operand2);
    }
}

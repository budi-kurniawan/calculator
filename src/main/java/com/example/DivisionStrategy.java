package com.example;

import java.math.BigDecimal;

public class DivisionStrategy implements CalculationStrategy {

    @Override
    public BigDecimal execute(BigDecimal operand1, BigDecimal operand2) {
        return operand1.divide(operand2);
    }
}

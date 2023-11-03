package com.example.algorithm;

import java.math.BigDecimal;

public class AdditionStrategy implements CalculationStrategy {

    @Override
    public BigDecimal execute(BigDecimal operand1, BigDecimal operand2) {
        return operand1.add(operand2);
    }
}

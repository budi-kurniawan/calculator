package com.example;

import java.math.BigDecimal;

public interface CalculationStrategy {
    BigDecimal execute(BigDecimal operand1, BigDecimal operand2);
}

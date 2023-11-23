package com.example.algorithm;

import java.math.BigDecimal;

import com.example.exception.InvalidInputException;

public interface CalculationStrategy {
    BigDecimal execute(BigDecimal operand1, BigDecimal operand2) throws InvalidInputException;
}

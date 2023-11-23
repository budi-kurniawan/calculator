package com.example.algorithm;

import java.math.BigDecimal;

import com.example.exception.InvalidInputException;

public class DivisionStrategy implements CalculationStrategy {

    @Override
    public BigDecimal execute(BigDecimal operand1, BigDecimal operand2) throws InvalidInputException {
    	if (operand2.equals(BigDecimal.ZERO)) {
    		throw new InvalidInputException("Division by zero not allowed.");
    	}
        return operand1.divide(operand2);
    }
}

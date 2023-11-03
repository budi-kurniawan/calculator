package com.example.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.algorithm.Context;
import com.example.algorithm.DivisionStrategy;
import com.example.exception.InvalidInputException;

public class DivisionStrategyTest {

    private Context context;
    
    @BeforeEach
    public void setUp() {
        context = new Context(new DivisionStrategy());
    }
    
    @Test
    public void testDivision() throws InvalidInputException {
        BigDecimal result = context.executeStrategy(BigDecimal.ONE, BigDecimal.TWO);
        assertEquals(result.doubleValue(), 0.5);
    }
}

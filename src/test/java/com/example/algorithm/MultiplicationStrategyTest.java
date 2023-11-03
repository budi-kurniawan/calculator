package com.example.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.exception.InvalidInputException;

public class MultiplicationStrategyTest {

    private Context context;
    
    @BeforeEach
    public void setUp() {
        context = new Context(new MultiplicationStrategy());
    }
    
    @Test
    public void testMultiplication() throws InvalidInputException {
        BigDecimal result = context.executeStrategy(BigDecimal.ONE, BigDecimal.TWO);
        assertEquals(result.doubleValue(), 2);
    }
}

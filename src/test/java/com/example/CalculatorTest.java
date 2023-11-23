package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.exception.AlgorithmNotFoundException;
import com.example.exception.InvalidInputException;

public class CalculatorTest {

    private Calculator calculator;
    
    @BeforeEach
    public void setUp() {
        calculator = CalculatorBuilder.build();
    }
    
    @Test
    public void testAddition() throws InvalidInputException, AlgorithmNotFoundException {
        String input = "1.2 + 2.0987654321";
        BigDecimal result = calculator.calculate(input);
        assertEquals(result.doubleValue(), 3.2987654321);
    }

    @Test
    public void testSubtraction() throws InvalidInputException, AlgorithmNotFoundException {
        String input = "100.000 - 10.000";
        BigDecimal result = calculator.calculate(input);
        assertEquals(result.doubleValue(), 90.000);
    }

    @Test
    public void testMultiplication() throws InvalidInputException, AlgorithmNotFoundException {
        String input = "9.0 * 10.000";
        BigDecimal result = calculator.calculate(input);
        assertEquals(result.doubleValue(), 90.000);
    }

    @Test
    public void testDivision() throws InvalidInputException, AlgorithmNotFoundException {
        String input = "9.0 / 10";
        BigDecimal result = calculator.calculate(input);
        assertEquals(result.doubleValue(), .900);
    }
    
    @Test
    public void testInvalidOperand1() {
        Throwable exception = assertThrows(InvalidInputException.class, 
                () -> calculator.calculate("a + 7"));
        assertEquals("a is not a valid number.", exception.getMessage());
    }

    @Test
    public void testInvalidOperand2() {
        Throwable exception = assertThrows(InvalidInputException.class, 
                () -> calculator.calculate("2 + 12c"));
        assertEquals("12c is not a valid number.", exception.getMessage());
    }
    
    
    @Test
    public void testAbc() throws InvalidInputException, AlgorithmNotFoundException {
        Throwable exception = assertThrows(InvalidInputException.class, 
                () -> calculator.calculate("9 / 0"));
        assertEquals("Division by zero not allowed.", exception.getMessage());
    }

}

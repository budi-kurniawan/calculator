package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.exception.InvalidInputException;

public class CalculatorTest {

    private Calculator calculator;
    
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    public void testIsValidOperand() {
        String operand = "123.43945849859485948958495849594";
        assertTrue(calculator.isValidOperand(operand));

        operand = "ABC.43945849859485948958495849594";
        assertFalse(calculator.isValidOperand(operand));

        operand = "-1";
        assertFalse(calculator.isValidOperand(operand));
    }
    
    @Test
    public void testIsValidOperation() {
        String operation = "*";
        assertTrue(calculator.isValidOperation(operation));

        operation = "^";
        assertFalse(calculator.isValidOperation(operation));
    }
    
    @Test
    public void testAddition() throws InvalidInputException {
        String input = "1.2 + 2.0987654321";
        BigDecimal result = calculator.calculate(input);
        assertEquals(result.doubleValue(), 3.2987654321);
    }

    @Test
    public void testSubtraction() throws InvalidInputException {
        String input = "100.000 - 10.000";
        BigDecimal result = calculator.calculate(input);
        assertEquals(result.doubleValue(), 90.000);
    }

    @Test
    public void testMultiplication() throws InvalidInputException {
        String input = "9.0 * 10.000";
        BigDecimal result = calculator.calculate(input);
        assertEquals(result.doubleValue(), 90.000);
    }

    @Test
    public void testDivision() throws InvalidInputException {
        String input = "9.0 / 10";
        BigDecimal result = calculator.calculate(input);
        assertEquals(result.doubleValue(), .900);
    }
    
    @Test
    public void testInvalidOperand1() {
        Throwable exception = assertThrows(InvalidInputException.class, 
                () -> calculator.calculate("a + 7"));
        assertEquals("a is not a valid number", exception.getMessage());
    }

    @Test
    public void testInvalidOperand2() {
        Throwable exception = assertThrows(InvalidInputException.class, 
                () -> calculator.calculate("2 + 12c"));
        assertEquals("12c is not a valid number", exception.getMessage());
    }

}

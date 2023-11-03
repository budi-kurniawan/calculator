package com.example.validator;

import static com.example.CalculatorBuilder.OPERAND_PATTERN;
import static com.example.CalculatorBuilder.OPERATION_PATTERN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.exception.InvalidInputException;
public class InputValidatorTest {

    private InputValidator inputValidator;
    
    @BeforeEach
    public void setUp() {
        inputValidator = new SimpleInputValidator(OPERAND_PATTERN, OPERATION_PATTERN);
    }
    
    @Test
    public void testValidate() throws InvalidInputException {
        inputValidator.validate("10000", "*", "100");
    }
    
    @Test
    public void testInvalidOperand1() {
        Throwable exception = assertThrows(InvalidInputException.class, 
                () -> inputValidator.validate("abc", "-", "19"));
        assertEquals("abc is not a valid number.", exception.getMessage());
    }

}

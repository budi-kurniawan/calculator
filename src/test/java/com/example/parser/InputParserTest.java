package com.example.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.exception.InvalidInputException;

public class InputParserTest {

    private InputParser inputParser;
    
    @BeforeEach
    public void setUp() {
        inputParser = new SimpleInputParser();
    }
    
    @Test
    public void testParse() throws InvalidInputException {
        String input = "100.000 - 10.000";
        ParseResult parseResult = inputParser.parse(input);
        assertNotNull(parseResult.operand1());
        assertNotNull(parseResult.operation());
        assertNotNull(parseResult.operand2());
    }
    
    @Test
    public void testInvalidOperand1() {
        Throwable exception = assertThrows(InvalidInputException.class, 
                () -> inputParser.parse("invalid input"));
        assertEquals("Invalid input length.", exception.getMessage());
    }

}

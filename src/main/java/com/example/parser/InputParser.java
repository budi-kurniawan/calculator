package com.example.parser;

import com.example.exception.InvalidInputException;

public interface InputParser {
    ParseResult parse(String input) throws InvalidInputException;
}

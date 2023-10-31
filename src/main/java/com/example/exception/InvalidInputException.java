package com.example.exception;

/**
 * An exception thrown due to invalid input
 */
public class InvalidInputException extends Exception {
    
    private static final long serialVersionUID = 3310515563129428328L;

    public InvalidInputException(String message) {
        super(message);
    }

}

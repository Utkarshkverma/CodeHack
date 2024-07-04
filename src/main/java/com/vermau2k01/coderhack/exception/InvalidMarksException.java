package com.vermau2k01.coderhack.exception;

public class InvalidMarksException extends RuntimeException {

    public InvalidMarksException()
    {
        super("Marks should be between 0 and 100");
    }

}

package com.simeon.lab2.exceptions;

public class SerializationException extends Exception {
    public SerializationException(String message, Exception e) {
        super(message, e);
    }

    public SerializationException(String message) {
        super(message);
    }
}


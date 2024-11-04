package com.simeon.lab2.exceptions;

public class ServerError extends RuntimeException {
    public ServerError(String message) {
        super(message);
    }
}

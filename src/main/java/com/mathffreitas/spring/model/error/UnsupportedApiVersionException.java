package com.mathffreitas.spring.model.error;

public class UnsupportedApiVersionException extends RuntimeException {
    public UnsupportedApiVersionException(String message) {
        super(message);
    }
}

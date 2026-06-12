package com.mathffreitas.spring.model.error;

public class NotAvailableContentException extends RuntimeException {
    public NotAvailableContentException(String message) {
        super(message);
    }
}

package com.example.Spring_E_Com.exception;

public class BadRequestException extends org.apache.coyote.BadRequestException {
    public BadRequestException(String message) {
        super(message);
    }
}

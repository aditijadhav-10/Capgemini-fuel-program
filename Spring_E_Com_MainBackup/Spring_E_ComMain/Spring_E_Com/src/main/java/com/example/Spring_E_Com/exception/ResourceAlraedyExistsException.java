package com.example.Spring_E_Com.exception;

public class ResourceAlraedyExistsException extends RuntimeException{
    public ResourceAlraedyExistsException(String message) {
        super(message);
    }
}

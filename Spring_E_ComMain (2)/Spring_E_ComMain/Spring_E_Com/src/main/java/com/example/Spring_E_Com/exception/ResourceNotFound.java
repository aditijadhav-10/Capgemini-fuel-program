package com.example.Spring_E_Com.exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message){
        super(message);

    }
}

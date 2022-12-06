package com.example.footballmanager.exception;

public class EntityDoesNotExistException extends RuntimeException{

    public EntityDoesNotExistException(String message) {
        super(message);
    }
}

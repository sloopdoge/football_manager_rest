package com.example.footballmanager.exception;

public class EntityAlreadyInUseException extends RuntimeException{
    public EntityAlreadyInUseException(String message) {
        super(message);
    }
}

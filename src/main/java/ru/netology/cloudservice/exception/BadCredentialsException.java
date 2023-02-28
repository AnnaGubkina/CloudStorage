package ru.netology.cloudservice.exception;

public class BadCredentialsException extends RuntimeException{

    public BadCredentialsException (String message) {
        super(message);
    }
}

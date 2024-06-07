package com.fastcampus.boardserver.auth.exception;

public class NotExistUserException extends RuntimeException {
    public NotExistUserException(String message) {
        super(message);
    }
}

package com.fastcampus.boardserver.global.exception;

public class UnAuthorizedUserException extends RuntimeException{
    public UnAuthorizedUserException(String message) {
        super(message);
    }
}

package com.fastcampus.boardserver.auth.exception;

public class DuplicatedIDException extends RuntimeException {
    public DuplicatedIDException(String message) {
        super(message);
    }
}

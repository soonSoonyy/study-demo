package com.fastcampus.boardserver.global.exception;

public class DuplicatedIDException extends RuntimeException {
    public DuplicatedIDException(String message) {
        super(message);
    }
}

package com.fastcampus.boardserver.global.exception;

import com.fastcampus.boardserver.global.response.ResultCode;

public class NotExistUserException extends CustomException {
    public NotExistUserException() {
        super(ResultCode.NOT_EXIST_USER);
    }

    public NotExistUserException(Throwable cause) {
        super(ResultCode.NOT_EXIST_USER, cause);
    }
}

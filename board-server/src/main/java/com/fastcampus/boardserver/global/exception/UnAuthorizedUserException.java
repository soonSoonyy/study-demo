package com.fastcampus.boardserver.global.exception;

import com.fastcampus.boardserver.global.response.ResultCode;

public class UnAuthorizedUserException extends CustomException {

    public UnAuthorizedUserException() {
        super(ResultCode.UNAUTHORIZED_USER);
    }

    public UnAuthorizedUserException(Throwable cause) {
        super(ResultCode.UNAUTHORIZED_USER, cause);
    }
}

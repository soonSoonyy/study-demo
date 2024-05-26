package com.fastcampus.boardserver.global.exception;

import com.fastcampus.boardserver.global.response.ResultCode;

public class ForbiddenException extends CustomException {
    public ForbiddenException() {
        super(ResultCode.FORBIDDEN);
    }

    public ForbiddenException(Throwable cause) {
        super(ResultCode.FORBIDDEN, cause);
    }
}

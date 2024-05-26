package com.fastcampus.boardserver.global.exception;

import com.fastcampus.boardserver.global.response.ResultCode;

public class WithdrawnUserAccessException extends CustomException {
    public WithdrawnUserAccessException() {
        super(ResultCode.WITHDRAWN_USER_ACCESS);
    }

    public WithdrawnUserAccessException(Throwable cause) {
        super(ResultCode.WITHDRAWN_USER_ACCESS, cause);
    }
}

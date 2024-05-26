package com.fastcampus.boardserver.global.exception;

import com.fastcampus.boardserver.global.response.ResultCode;

public class DuplicatedIDException extends CustomException {

    public DuplicatedIDException() {
        super(ResultCode.DUPLICATE_USER_ID);
    }

    public DuplicatedIDException(Throwable cause) {
        super(ResultCode.DUPLICATE_USER_ID, cause);
    }
}

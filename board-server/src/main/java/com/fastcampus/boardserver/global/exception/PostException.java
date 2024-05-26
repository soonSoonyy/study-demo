package com.fastcampus.boardserver.global.exception;

import com.fastcampus.boardserver.global.response.ResultCode;

public class PostException extends CustomException {
    public PostException(ResultCode resultCode) {
        super(resultCode);
    }

    public PostException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }

}

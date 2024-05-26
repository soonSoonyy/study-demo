package com.fastcampus.boardserver.global.exception;

import com.fastcampus.boardserver.global.response.ResultCode;

public class ParameterErrorException extends CustomException {
    public ParameterErrorException(ResultCode resultCode) {
            super(resultCode);
        }

    public ParameterErrorException(ResultCode resultCode, Throwable cause) {
        super(resultCode, cause);
    }
}

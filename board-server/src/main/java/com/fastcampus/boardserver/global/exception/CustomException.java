package com.fastcampus.boardserver.global.exception;

import com.fastcampus.boardserver.global.response.ResultCode;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException{
    private final ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public CustomException(ResultCode resultCode, Throwable cause) {
        super(resultCode.getMessage(), cause);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public HttpStatus getHttpStatus() {
        return resultCode.getHttpStatus();
    }

    public String getCode() {
        return resultCode.getCode();
    }

    public String getMessage() {
        return resultCode.getMessage();
    }
}

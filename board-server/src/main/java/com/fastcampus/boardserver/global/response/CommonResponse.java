package com.fastcampus.boardserver.global.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> {

    private HttpStatus status;
    private String code;
    private String message;
    private T body;
}

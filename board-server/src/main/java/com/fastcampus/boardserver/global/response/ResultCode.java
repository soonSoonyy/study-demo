package com.fastcampus.boardserver.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResultCode {
    SUCCESS(HttpStatus.OK, "200", "Success"),  // 성공
    FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Fail"),  // 실패

    // 사용자 관련 오류
    DUPLICATE_USER_ID(HttpStatus.CONFLICT, "409", "Duplicate User ID"),  // 중복된 사용자 ID
    NOT_EXIST_USER(HttpStatus.NOT_FOUND, "404", "Not Exist User"),  // 존재하지 않는 사용자
    WITHDRAWN_USER_ACCESS(HttpStatus.BAD_REQUEST, "400", "Withdrawn User Access"),  // 탈퇴한 사용자
    UNAUTHORIZED_USER(HttpStatus.UNAUTHORIZED, "401", "Unauthorized User"),  // 인증되지 않은 사용자
    FORBIDDEN(HttpStatus.FORBIDDEN, "403", "Forbidden"),  // 접근 금지

    // 요청 관련 오류
    WRONG_REQUEST(HttpStatus.BAD_REQUEST, "400", "Wrong Request"),  // 잘못된 요청
    PARAMETER_TYPE_ERROR(HttpStatus.BAD_REQUEST, "400", "Parameter Type Error"),  // 잘못된 매개변수 타입
    PARAMETER_TYPE_MISMATCH(HttpStatus.BAD_REQUEST, "400", "Parameter MisMatch Error"),  // 잘못된 매개변수 타입
    PARAMETER_BIND_ERROR(HttpStatus.BAD_REQUEST, "400", "Parameter Bind Error"),  // 매개변수 바인딩 오류
    PARAMETER_VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "400", "Parameter Validation Error"),  // 매개변수 검증 오류
    PARAMETER_NULL_ERROR(HttpStatus.BAD_REQUEST, "400", "Parameter Null Error"),  // 매개변수 null 오류
    PARAMETER_EMPTY_ERROR(HttpStatus.BAD_REQUEST, "400", "Parameter Empty Error"),  // 매개변수 빈 값 오류

    // 게시물 관련 오류
    POST_REGISTRATION_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Post Registration Error"),  // 게시물 등록 오류
    POST_UPDATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Post Update Error"),  // 게시물 수정 오류
    POST_DELETE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Post Delete Error"),  // 게시물 삭제 오류

    // 댓글 관련 오류
    COMMENT_REGISTRATION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Comment Registration Error"),  // 댓글 등록 오류
    COMMENT_UPDATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Comment Update Error"),  // 댓글 수정 오류
    COMMENT_DELETE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Comment Delete Error"),  // 댓글 삭제 오류

    // 알 수 없는 오류
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "Unknown Error");  // 알 수 없는 오류

    ;

    private HttpStatus httpStatus;
    private String code;
    private String message;

    ResultCode(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}

package com.soon83.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 0. 공통 오류
    SYSTEM_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COM001", "일시적인 오류가 발생하였습니다. 잠시후 다시 시도해주세요."),
    ARGUMENT_NOT_VALID_ERROR(HttpStatus.BAD_REQUEST, "COM002", "올바르지 않은 파라미터입니다."),
    REQUEST_JSON_PARSE_ERROR(HttpStatus.BAD_REQUEST, "COM003", "올바르지 않은 포맷입니다."),
    ARGUMENT_TYPE_MISMATCH_ERROR(HttpStatus.BAD_REQUEST, "COM004", "올바르지 않은 파라미터입니다."),

    // 1. 회원 오류
    MEMBER_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "MBR001", "존재하지 않는 회원입니다."),
    MEMBER_ALREADY_EXISTS_ERROR(HttpStatus.CONFLICT, "MBR002", "이미 존재하는 회원입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public int getStatus() {
        return httpStatus.value();
    }
}

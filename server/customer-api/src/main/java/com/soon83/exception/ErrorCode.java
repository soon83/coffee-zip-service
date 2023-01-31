package com.soon83.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    // 0. 공통 에러
    COMMON_NIMTAT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COM001", "이 오류는 님탓입니다."),
    COMMON_INVALID_PARAMETERS(HttpStatus.BAD_REQUEST, "COM002", "파라미터가 똑바로 안들어와서 화가나요"),

    // 0. 회원 에러
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MBR001", "존재하는 회원이 없습니다."),
    MEMBER_KILLED_BY_ME(HttpStatus.NOT_FOUND, "MBR002", "회원을 처리하였습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}

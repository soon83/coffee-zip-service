package com.soon83.exception;

import com.soon83.ErrorRes;
import com.soon83.Res;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    /**
     * HttpStatus 를 직접 지정한다
     * 요청을 처리 중 오류 발생
     */
    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Res<ErrorRes>> applicationException(ApplicationException e) {
        log.error("[ApplicationException] error = {}", e);
        ErrorCode errorCode = e.getErrorCode();
        ErrorRes errorRes = ErrorRes.of(errorCode.getCode(), errorCode.getMessage());
        return ResponseEntity.status(e.getErrorCode().getStatus()).body(Res.failure(errorRes));
    }

    /**
     * HttpStatus 400
     * Parameter Binding Error
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Res<ErrorRes>> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("[MethodArgumentNotValidException] error = {}", e);
        ErrorCode errorCode = ErrorCode.COMMON_INVALID_PARAMETERS;
        ErrorRes errorRes = ErrorRes.of(errorCode.getCode(), errorCode.getMessage(), e.getBindingResult());
        return ResponseEntity.badRequest().body(Res.failure(errorRes));
    }

    /**
     * HttpStatus 500
     * System Error
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Res<ErrorRes>> exception(Exception e) {
        log.error("[Exception] error = {}", e);
        ErrorCode errorCode = ErrorCode.COMMON_NIMTAT_ERROR;
        ErrorRes errorRes = ErrorRes.of(errorCode.getCode(), errorCode.getMessage());
        return ResponseEntity.internalServerError().body(Res.failure(errorRes));
    }
}

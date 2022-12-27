package com.soon83;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.soon83.Res.ResponseType.FAILURE;
import static com.soon83.Res.ResponseType.SUCCESS;

@Getter
public class Res<T> {

    private boolean success; // success: 200, 300, failure: 400, 500
    private String code;
    private String message;
    private T data;
    private List<ErrorRes.FieldError> errors;

    private Res(ResponseType responseType) {
        this.success = responseType.isSuccess();
        this.code = responseType.getCode();
        this.message = responseType.getMessage();
    }

    private Res(ResponseType responseType, T data) {
        this.success = responseType.isSuccess();
        this.code = responseType.getCode();
        this.message = responseType.getMessage();
        this.data = data;
    }

    private Res(ResponseType responseType, String code, String message, List<ErrorRes.FieldError> errors) {
        this.success = responseType.isSuccess();
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public static <T> Res<T> success() {
        return new Res<>(SUCCESS);
    }

    public static <T> Res<T> success(T data) {
        return new Res<>(SUCCESS, data);
    }

    public static <T> Res<T> failure() {
        return new Res<>(FAILURE);
    }

    public static <T> Res<T> failure(ErrorRes errorRes) {
        return new Res<>(FAILURE, errorRes.getCode(), errorRes.getMessage(), errorRes.getFieldErrors());
    }

    @Getter
    @RequiredArgsConstructor
    public enum ResponseType {
        SUCCESS(true, "OK", "응답 성공"),
        FAILURE(false, "FAIL", "응답 실패"),
        ;

        private final boolean success;
        private final String code;
        private final String message;
    }
}

package com.soon83;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.soon83.Res.ResponseType.SUCCESS;

@Getter
public class Res<T> {

    private final boolean success; // success: 200, 300, failure: 400, 500
    private final String code;
    private final String message;
    private T data;

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

    public static <T> Res<T> success() {
        return new Res<>(SUCCESS);
    }

    public static <T> Res<T> success(T data) {
        return new Res<>(SUCCESS, data);
    }

    @Getter
    @RequiredArgsConstructor
    public enum ResponseType {
        SUCCESS(true, "성공"),
        FAILURE(false, "실패"),
        ;

        private final boolean success;
        private final String message;

        public String getCode() {
            return this.name();
        }
    }
}

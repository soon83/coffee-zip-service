package com.soon83;

import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class ErrorRes {

    private String code;
    private String message;
    private List<FieldError> fieldErrors;

    public static ErrorRes of(String code, String message) {
        return ErrorRes.builder()
                .code(code)
                .message(message)
                .fieldErrors(FieldError.of())
                .build();
    }

    public static ErrorRes of(String code, String message, BindingResult bindingResult) {
        return ErrorRes.builder()
                .code(code)
                .message(message)
                .fieldErrors(FieldError.of(bindingResult))
                .build();
    }

    @Getter
    public static class FieldError {
        private String field;
        private String value;
        private String reason;

        @Builder
        private FieldError(org.springframework.validation.FieldError fieldError) {
            this.field = fieldError.getField();
            this.value = fieldError.getRejectedValue() == null ? "" : fieldError.getRejectedValue().toString();
            this.reason = fieldError.getDefaultMessage();
        }

        public static List<FieldError> of() {
            return new ArrayList<>();
        }

        public static List<FieldError> of(BindingResult bindingResult) {
            return bindingResult.getFieldErrors().stream()
                    .map(FieldError::new)
                    .toList();
        }
    }
}

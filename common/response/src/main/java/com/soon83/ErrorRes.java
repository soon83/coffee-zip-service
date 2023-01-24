package com.soon83;

import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class ErrorRes {

    private final String code;
    private final String message;
    private List<FieldError> fieldErrors;

    public static ErrorRes of(String code, String message) {
        return ErrorRes.builder()
                .code(code)
                .message(message)
                .fieldErrors(new ArrayList<>())
                .build();
    }

    public static ErrorRes of(String code, String message, BindingResult bindingResult) {
        return ErrorRes.builder()
                .code(code)
                .message(message)
                .fieldErrors(FieldError.getFieldErrors(bindingResult))
                .build();
    }

    @Getter
    public static class FieldError {
        private final String field;
        private final String value;
        private final String reason;

        private FieldError(org.springframework.validation.FieldError fieldError) {
            this.field = fieldError.getField();
            this.value = fieldError.getRejectedValue() == null ? "" : fieldError.getRejectedValue().toString();
            this.reason = fieldError.getDefaultMessage();
        }

        public static List<FieldError> getFieldErrors(BindingResult bindingResult) {
            return bindingResult.getFieldErrors().stream()
                    .map(FieldError::new)
                    .toList();
        }
    }
}

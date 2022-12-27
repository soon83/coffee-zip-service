package com.soon83.model;

import com.soon83.entity.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

public class MemberDto {

    @Data
    public static class SearchCondition {
        private String memberName;
        private Integer memberAge;
        private Member.Gender memberGender;
    }

    @Data
    public static class CreateRequest {
        @NotBlank(message = "필수값")
        private String memberName;

        @NotNull(message = "필수값")
        private Integer memberAge;

        @NotNull(message = "필수값")
        private Member.Gender memberGender;
    }

    @Getter
    @Builder
    @ToString
    public static class CreateResponse {
        private Long memberId;
    }

    @Data
    public static class UpdateRequest {
        private String memberName;
        private Integer memberAge;
        private Member.Gender memberGender;
    }

    @Getter
    @Builder
    @ToString
    public static class MainResponse {
        private Long memberId;
        private String memberName;
        private Integer memberAge;
        private Member.Gender memberGender;
    }
}

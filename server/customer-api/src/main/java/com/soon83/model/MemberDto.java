package com.soon83.model;

import com.soon83.entity.Member;
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
        private String memberName;
        private Integer memberAge;
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

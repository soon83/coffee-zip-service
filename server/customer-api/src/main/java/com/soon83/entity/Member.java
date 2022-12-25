package com.soon83.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Member {

    private Long id;
    private String name;
    private Integer age;
    private Gender gender;

    public enum Gender {
        MALE, FEMALE
    }
}

package com.soon83.exception.member;

import com.soon83.exception.ErrorCode;
import com.soon83.exception.SystemException;
import lombok.Getter;

@Getter
public class MemberAlreadyExistsException extends SystemException {
    public MemberAlreadyExistsException() {
        super(ErrorCode.MEMBER_ALREADY_EXISTS_ERROR);
    }
}

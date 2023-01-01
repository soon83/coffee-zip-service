package com.soon83.controller;

import com.soon83.entity.Member;
import com.soon83.model.MemberDto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.soon83.LinkUtil.location;
import static com.soon83.Res.success;

@Slf4j
@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    /**
     * 회원 단건 생성
     */
    @PostMapping
    public ResponseEntity saveMember(@RequestBody @Valid MemberDto.CreateRequest memberCreateRequest) {
        System.out.println("memberCreateRequest = " + memberCreateRequest);

        // TODO 회원 저장
        MemberDto.CreateResponse memberCreateResponse = MemberDto.CreateResponse.builder()
                .memberId(1L)
                .build();

        return ResponseEntity.created(location(memberCreateResponse.getMemberId()))
                .body(success(memberCreateResponse));
    }

    /**
     * 회원 목록 조회
     */
    @GetMapping
    public ResponseEntity getMembers(
            @ModelAttribute MemberDto.SearchCondition memberSearchCondition) {
        System.out.println("memberSearchCondition = " + memberSearchCondition);

        // TODO 회원 목록 조회
        List<MemberDto.MainResponse> memberListResponse = List.of(
                MemberDto.MainResponse.builder()
                        .memberId(1L)
                        .memberName("나패존")
                        .memberAge(1)
                        .memberGender(Member.Gender.FEMALE)
                        .build(),
                MemberDto.MainResponse.builder()
                        .memberId(2L)
                        .memberName("동네형")
                        .memberAge(2)
                        .memberGender(Member.Gender.MALE)
                        .build());
        /**
         * data: {
         *     content: [],
         *     pageable: {
         *         totalCount: 10000,
         *         page: 0,
         *         size: 10,
         *         totalPage: 1000
         *     }
         * }
         */
        Map<String, Object> map = Map.of(
                "content", memberListResponse,
                "pageable", Map.of(
                        "totalCount", 10000,
                        "page", 0,
                        "size", 10,
                        "totalPage", 1000)
        );

        return ResponseEntity.ok(success(map));
    }

    /**
     * 회원 단건 조회
     */
    @GetMapping("/{memberId}")
    public ResponseEntity getMember(@PathVariable Long memberId) {
        System.out.println("memberId = " + memberId);

        // TODO 회원 단건 조회
        MemberDto.MainResponse memberResponse = MemberDto.MainResponse.builder()
                .memberId(1L)
                .memberName("나패존")
                .memberAge(1)
                .memberGender(Member.Gender.FEMALE)
                .build();

        return ResponseEntity.ok(success(memberResponse));
    }

    /**
     * 회원 단건 수정
     */
    @PutMapping("/{memberId}")
    public ResponseEntity editMember(@PathVariable Long memberId, @RequestBody MemberDto.UpdateRequest memberUpdateRequest) {
        System.out.println("memberId = " + memberId);
        System.out.println("memberUpdateRequest = " + memberUpdateRequest);

        // TODO 회원 단건 수정
        return ResponseEntity.ok(success());
    }

    /**
     * 회원 단건 삭제
     */
    @DeleteMapping("/{memberId}")
    public ResponseEntity removeMember(@PathVariable Long memberId) {
        System.out.println("memberId = " + memberId);

        // TODO 회원 단건 삭제
        return ResponseEntity.ok(success());
    }
}

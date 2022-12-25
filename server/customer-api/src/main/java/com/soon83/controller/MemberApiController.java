package com.soon83.controller;

import com.soon83.entity.Member;
import com.soon83.model.MemberDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberApiController {

    /**
     * 회원 단건 생성
     */
    @PostMapping
    public ResponseEntity<MemberDto.CreateResponse> saveMember(@RequestBody MemberDto.CreateRequest memberCreateRequest) throws URISyntaxException {
        System.out.println("memberCreateRequest = " + memberCreateRequest);

        // TODO 회원 저장

        return ResponseEntity.created(new URI("/api/members/1"))
                .body(MemberDto.CreateResponse.builder()
                        .memberId(1L)
                        .build());
    }

    /**
     * 회원 목록 조회
     */
    @GetMapping
    public ResponseEntity<List<MemberDto.MainResponse>> getMembers(
            @ModelAttribute MemberDto.SearchCondition memberSearchCondition) {
        System.out.println("memberSearchCondition = " + memberSearchCondition);

        // TODO 회원 목록 조회

        return ResponseEntity.ok(
                List.of(
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
                                .build()));
    }

    /**
     * 회원 단건 조회
     */
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDto.MainResponse> getMember(@PathVariable Long memberId) {
        System.out.println("memberId = " + memberId);

        // TODO 회원 단건 조회

        return ResponseEntity.ok(MemberDto.MainResponse.builder()
                .memberId(1L)
                .memberName("나패존")
                .memberAge(1)
                .memberGender(Member.Gender.FEMALE)
                .build());
    }

    /**
     * 회원 단건 수정
     */
    @PutMapping("/{memberId}")
    public ResponseEntity<Void> editMember(@PathVariable Long memberId, @RequestBody MemberDto.UpdateRequest memberUpdateRequest) {
        System.out.println("memberId = " + memberId);
        System.out.println("memberUpdateRequest = " + memberUpdateRequest);

        // TODO 회원 단건 수정

        return ResponseEntity.noContent().build();
    }

    /**
     * 회원 단건 삭제
     */
    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> removeMember(@PathVariable Long memberId) {
        System.out.println("memberId = " + memberId);

        // TODO 회원 단건 삭제

        return ResponseEntity.noContent().build();
    }
}

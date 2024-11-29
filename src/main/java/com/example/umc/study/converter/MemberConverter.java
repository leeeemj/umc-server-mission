package com.example.umc.study.converter;

import com.example.umc.study.domain.Member;
import com.example.umc.study.domain.enums.Gender;
import com.example.umc.study.web.dto.MemberDto.MemberRequestDTO;
import com.example.umc.study.web.dto.MemberDto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {

        Gender gender = null;
        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        return Member.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .role(request.getRole())
                .memberPreferList(new ArrayList<>())
                .build();
    }
}
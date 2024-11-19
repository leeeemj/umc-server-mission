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

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .gender(gender)
                .nickname(request.getNickname())
                .memberPreferList(new ArrayList<>()) //리스트 초기화
                .build();
    }
}
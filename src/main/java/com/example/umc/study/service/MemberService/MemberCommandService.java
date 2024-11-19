package com.example.umc.study.service.MemberService;

import com.example.umc.study.domain.Member;
import com.example.umc.study.web.dto.MemberDto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDto request);
}

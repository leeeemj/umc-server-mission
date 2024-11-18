package com.example.umc.study.web.controller.MemberController;

import com.example.umc.study.ApiResponse.ApiResponse;
import com.example.umc.study.converter.MemberConverter;
import com.example.umc.study.domain.Member;
import com.example.umc.study.service.MemberService.MemberCommandService;
import com.example.umc.study.web.dto.MemberDto.MemberRequestDTO;
import com.example.umc.study.web.dto.MemberDto.MemberResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}

package com.example.umc.study.service.MemberService;


import com.example.umc.study.converter.MemberConverter;
import com.example.umc.study.domain.FoodCategory;
import com.example.umc.study.domain.Member;
import com.example.umc.study.domain.mapping.MemberPrefer;
import com.example.umc.study.converter.MemberPreferConverter;
import com.example.umc.study.ApiResponse.exception.handler.FoodCategoryHandler;
import com.example.umc.study.ApiResponse.code.status.ErrorStatus;
import com.example.umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import com.example.umc.study.repository.MemberRepository.MemberRepository;
import com.example.umc.study.web.dto.MemberDto.MemberRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}
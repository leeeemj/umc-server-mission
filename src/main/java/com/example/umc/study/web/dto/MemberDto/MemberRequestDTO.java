package com.example.umc.study.web.dto.MemberDto;

import com.example.umc.study.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String nickname;
        @NotNull
        Integer gender;
//        Integer birthYear;
//        Integer birthMonth;
//        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @ExistCategories
        List<Long> preferCategory;
    }
}

package com.example.umc.study.web.dto.MissionDto;

import com.example.umc.study.web.dto.MissionDto.MissionRequestDTO;
import com.example.umc.study.validation.annotation.MissionInProgress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDto {
        @NotNull
        private Long storeId;

        @NotBlank
        private String missionSpec;

        //null이면 500으로 default
        private Integer reward;

        @NotNull
        private LocalDate deadline;
    }

    @Getter
    public static class StartMissionDto {
        @NotNull
        @MissionInProgress
        private Long missionId;

        @NotNull
        private Long memberId;
    }
}

package com.example.umc.study.service.MissionService;
import com.example.umc.study.web.dto.MissionDto.MissionRequestDTO;

public interface MissionCommandService {
    Long addMissionToStore(MissionRequestDTO.CreateMissionDto request);
    Long startMission(MissionRequestDTO.StartMissionDto request);
}

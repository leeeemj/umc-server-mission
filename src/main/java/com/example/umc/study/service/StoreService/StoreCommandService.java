package com.example.umc.study.service.StoreService;

import com.example.umc.study.web.dto.StoreDto.StoreRequestDTO;

public interface StoreCommandService {
    Long createStore(StoreRequestDTO.CreateDto request);
}
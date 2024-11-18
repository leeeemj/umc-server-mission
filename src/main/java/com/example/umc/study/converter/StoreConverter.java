package com.example.umc.study.converter;

import com.example.umc.study.domain.Region;
import com.example.umc.study.domain.Store;
import com.example.umc.study.web.dto.StoreDto.StoreRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class StoreConverter {

    public static Store toStore(StoreRequestDTO.CreateDto request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .region(region)
                .build();
    }
}

package com.example.umc.study.service.StoreService;

import com.example.umc.study.ApiResponse.code.status.ErrorStatus;
import com.example.umc.study.ApiResponse.exception.handler.FoodCategoryHandler;
import com.example.umc.study.ApiResponse.exception.handler.RegionHandler;
import com.example.umc.study.converter.StoreConverter;
import com.example.umc.study.domain.Region;
import com.example.umc.study.domain.Store;
import com.example.umc.study.repository.RegionRepository.RegionRepository;
import com.example.umc.study.repository.StoreRepository.StoreRepository;
import com.example.umc.study.web.dto.StoreDto.StoreRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;


    @Transactional
    @Override
    public Long createStore(StoreRequestDTO.CreateDto request) {
        //region id에 해당하는 지역 찾기
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        Store store = StoreConverter.toStore(request, region);

        storeRepository.save(store);

        return store.getId();
    }
}
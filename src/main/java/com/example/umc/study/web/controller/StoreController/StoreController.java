package com.example.umc.study.web.controller.StoreController;


import com.example.umc.study.ApiResponse.ApiResponse;
import com.example.umc.study.service.StoreService.StoreCommandService;
import com.example.umc.study.web.dto.StoreDto.StoreRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;


    @PostMapping("")
    @Operation(summary = "특정 지역에 store 추가 API")
    public ApiResponse<Long> createStore(@RequestBody @Valid StoreRequestDTO.CreateDto request) {
        Long storeId = storeCommandService.createStore(request);

        return ApiResponse.onSuccess(storeId);
    }
}

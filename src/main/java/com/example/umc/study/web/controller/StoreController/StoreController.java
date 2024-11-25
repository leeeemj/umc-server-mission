package com.example.umc.study.web.controller.StoreController;


import com.example.umc.study.ApiResponse.ApiResponse;
import com.example.umc.study.converter.StoreConverter;
import com.example.umc.study.domain.Review;
import com.example.umc.study.service.ReviewService.ReviewCommandService;
import com.example.umc.study.service.StoreService.StoreCommandService;
import com.example.umc.study.service.StoreService.StoreQueryService;
import com.example.umc.study.validation.annotation.CheckPage;
import com.example.umc.study.validation.annotation.ExistStores;
import com.example.umc.study.web.dto.ReviewDto.ReviewRequestDTO;
import com.example.umc.study.web.dto.StoreDto.StoreRequestDTO;
import com.example.umc.study.web.dto.StoreDto.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@Validated
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;
    private final StoreQueryService storeQueryService;
    private final ReviewCommandService reviewCommandService;

    @PostMapping("")
    @Operation(summary = "특정 지역에 store 추가 API")
    public ApiResponse<Long> createStore(@RequestBody @Valid StoreRequestDTO.CreateStoreDto request) {
        Long storeId = storeCommandService.createStore(request);

        return ApiResponse.onSuccess(storeId);
    }

    //리뷰 조회
    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(
            @ExistStores @PathVariable(name = "storeId") Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }

    //리뷰 생성
    @Operation(summary = "리뷰 생성 api")
    @PostMapping("/reviews")
    public ApiResponse<Long> createReview(@RequestBody @Valid ReviewRequestDTO.CreateReviewDto request) {
        Long reviewId = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(reviewId);
    }

    //특정 가게 미션 목록 확인
}

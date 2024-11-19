package com.example.umc.study.web.controller.ReviewController;

import com.example.umc.study.ApiResponse.ApiResponse;
import com.example.umc.study.service.ReviewService.ReviewCommandService;
import com.example.umc.study.web.dto.ReviewDto.ReviewRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewCommandService reviewCommandService;
    @Operation(summary = "리뷰 생성 api")
    @PostMapping("")
    public ApiResponse<Long> createReview(@RequestBody @Valid ReviewRequestDTO.CreateReviewDto request) {
        Long reviewId = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(reviewId);
    }
}

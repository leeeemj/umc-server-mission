package com.example.umc.study.service.ReviewService;

import com.example.umc.study.web.dto.ReviewDto.ReviewRequestDTO;

public interface ReviewCommandService {
    Long createReview(ReviewRequestDTO.CreateReviewDto request);
}

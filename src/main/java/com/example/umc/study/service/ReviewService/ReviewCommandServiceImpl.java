package com.example.umc.study.service.ReviewService;

import com.example.umc.study.ApiResponse.code.status.ErrorStatus;
import com.example.umc.study.ApiResponse.exception.handler.StoreHandler;
import com.example.umc.study.domain.Member;
import com.example.umc.study.domain.Review;
import com.example.umc.study.domain.Store;
import com.example.umc.study.repository.MemberRepository.MemberRepository;
import com.example.umc.study.repository.ReviewRepository.ReviewRepository;
import com.example.umc.study.repository.StoreRepository.StoreRepository;
import com.example.umc.study.web.dto.ReviewDto.ReviewRequestDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;


    @Transactional
    @Override
    public Long createReview(ReviewRequestDTO.CreateReviewDto request) {
        // 가게 존재 여부 확인
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        //멤버 하드코딩
        Member member = memberRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("사용자가 존재하지 않습니다."));

        // 리뷰 생성
        Review review = Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .store(store)
                .member(member)
                .build();

        reviewRepository.save(review);

        return review.getId();
    }


}

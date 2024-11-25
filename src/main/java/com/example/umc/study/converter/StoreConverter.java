package com.example.umc.study.converter;

import com.example.umc.study.domain.Region;
import com.example.umc.study.domain.Review;
import com.example.umc.study.domain.Store;
import com.example.umc.study.web.dto.StoreDto.StoreRequestDTO;
import com.example.umc.study.web.dto.StoreDto.StoreResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreConverter {

    public static Store toStore(StoreRequestDTO.CreateStoreDto request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .region(region)
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getNickname())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getTitle())
                .build();
    }
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());
        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}

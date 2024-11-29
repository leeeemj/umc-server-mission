package com.example.umc.study.service.StoreService;

import com.example.umc.study.domain.Mission;
import com.example.umc.study.domain.Review;
import com.example.umc.study.domain.Store;
import com.example.umc.study.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
    Page<Review> getMemberReviewList(Long MemberId, Integer page);
    Page<MemberMission> getMemberMissionList(Long MemberId, Integer page);
}

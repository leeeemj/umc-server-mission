package com.example.umc.study.repository.ReviewRepository;


import com.example.umc.study.domain.Review;
import com.example.umc.study.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}
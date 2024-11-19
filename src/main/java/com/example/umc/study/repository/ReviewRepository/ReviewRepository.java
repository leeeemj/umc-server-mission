package com.example.umc.study.repository.ReviewRepository;


import com.example.umc.study.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
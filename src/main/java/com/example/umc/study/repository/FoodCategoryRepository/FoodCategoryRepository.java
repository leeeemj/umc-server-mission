package com.example.umc.study.repository.FoodCategoryRepository;

import com.example.umc.study.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}

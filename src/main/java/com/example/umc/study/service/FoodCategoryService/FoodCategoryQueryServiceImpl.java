package com.example.umc.study.service.FoodCategoryService;

import com.example.umc.study.repository.FoodCategoryRepository.FoodCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService {
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public boolean doCategoriesExist(List<Long> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}

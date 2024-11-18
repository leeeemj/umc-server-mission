package com.example.umc.study.service.FoodCategoryService;

import java.util.List;

public interface FoodCategoryQueryService {
    boolean doCategoriesExist(List<Long> ids);
}

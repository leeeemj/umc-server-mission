package com.example.umc.study.repository.StoreRepository;

import com.example.umc.study.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}

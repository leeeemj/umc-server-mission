package com.example.umc.study.ApiResponse.exception.handler;

import com.example.umc.study.ApiResponse.code.BaseErrorCode;
import com.example.umc.study.ApiResponse.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

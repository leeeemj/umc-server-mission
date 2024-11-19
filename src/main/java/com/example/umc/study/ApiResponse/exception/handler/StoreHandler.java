package com.example.umc.study.ApiResponse.exception.handler;

import com.example.umc.study.ApiResponse.code.BaseErrorCode;
import com.example.umc.study.ApiResponse.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

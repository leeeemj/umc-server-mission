package com.example.umc.study.ApiResponse.exception.handler;

import com.example.umc.study.ApiResponse.code.BaseErrorCode;
import com.example.umc.study.ApiResponse.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

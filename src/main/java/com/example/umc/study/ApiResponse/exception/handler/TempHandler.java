package com.example.umc.study.ApiResponse.exception.handler;

import com.example.umc.study.ApiResponse.code.BaseErrorCode;
import com.example.umc.study.ApiResponse.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

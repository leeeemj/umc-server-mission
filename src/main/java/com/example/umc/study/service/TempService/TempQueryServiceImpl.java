package com.example.umc.study.service.TempService;

import com.example.umc.study.ApiResponse.code.status.ErrorStatus;
import com.example.umc.study.ApiResponse.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}

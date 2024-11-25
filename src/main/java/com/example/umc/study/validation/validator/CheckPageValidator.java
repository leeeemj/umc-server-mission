package com.example.umc.study.validation.validator;


import com.example.umc.study.ApiResponse.code.status.ErrorStatus;
import com.example.umc.study.validation.annotation.CheckPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext constraintValidatorContext) {
        //page가 1 이상인지 확인
        boolean isValid = page != null && page >= 1;
        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(ErrorStatus.INVALID_PAGE.toString())
                    .addConstraintViolation();
        }
        return isValid;
    }
}

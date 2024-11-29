package com.example.umc.study.validation.validator;

import nonapi.io.github.classgraph.json.JSONUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckPageAspect {


    @Pointcut("@annotation(com.example.umc.study.validation.annotation.CheckPage)")
    public void checkPageAnnotation() {}

    @Around("checkPageAnnotation() && args(page, ..)")
    public Object adjustPageBeforeMethod(ProceedingJoinPoint joinPoint, Integer page) throws Throwable {
        System.out.println("page 조정 시작");
        if (page != null && page >= 1) {
            page = page - 1; // page 값을 -1
            System.out.println("조정된 page 값: " + page);
        }

        // 컨트롤러 메소드로 페이지 값을 전달하면서 실행
        Object[] args = joinPoint.getArgs();
        args[0] = page; // 수정된 page 값을 설정

        return joinPoint.proceed(args); // 수정된 값을 가진 파라미터로 메소드 실행
    }
}

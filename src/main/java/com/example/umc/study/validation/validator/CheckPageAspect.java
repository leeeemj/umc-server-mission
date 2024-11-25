package com.example.umc.study.validation.validator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckPageAspect {
    @Pointcut("@annotation(com.example.umc.study.validation.annotation.CheckPage)")
    public void checkPageAnnotation() {}

    @Around("checkPageAnnotation()")
    public Object validateAndConvertPage(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Integer) {
                Integer page = (Integer) args[i];
                if (page < 1) {
                    throw new IllegalArgumentException("페이지는 1보다 커야합니다.");
                }
                args[i] = page - 1;
            }
        }

        return joinPoint.proceed(args);
    }

}

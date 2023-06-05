package org.seminify.spring5fs.aspect2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.HashMap;
import java.util.Map;

@Aspect
public class CacheAspect2 {
    private Map<Long, Object> cache = new HashMap<>();

    @Around("org.seminify.spring5fs.aspect2.CommonPointcut.commonTarget()")
    public Object execute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long num = (Long) proceedingJoinPoint.getArgs()[0];
        if (cache.containsKey(num)) {
            System.out.printf("CacheAspect : Cache에서 구함 [%d]\n", num);
            return cache.get(num);
        }
        Object result = proceedingJoinPoint.proceed();
        cache.put(num, result);
        System.out.printf("CacheAspect : Cache에 추가 [%d]\n", num);
        return result;
    }
}

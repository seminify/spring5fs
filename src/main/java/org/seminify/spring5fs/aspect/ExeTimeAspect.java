package org.seminify.spring5fs.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ExeTimeAspect {
    @Pointcut("execution(public * org.seminify.spring5fs.spring..*(..))")
    private void publicTarget() {
    }

    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        try {
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            long finish = System.nanoTime();
            Signature signature = proceedingJoinPoint.getSignature();
            System.out.printf("%s.%s(%s) 실행 시간 : %dns\n", proceedingJoinPoint.getTarget().getClass().getSimpleName(), signature.getName(), Arrays.toString(proceedingJoinPoint.getArgs()), (finish - start));
        }
    }
}

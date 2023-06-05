package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtxWithCache;
import org.seminify.spring5fs.spring.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspectWithCache {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppCtxWithCache.class);
        Calculator calculator = annotationConfigApplicationContext.getBean("calculator", Calculator.class);
        calculator.factorial(7);
        calculator.factorial(7);
        calculator.factorial(5);
        calculator.factorial(5);
        annotationConfigApplicationContext.close();
    }
}

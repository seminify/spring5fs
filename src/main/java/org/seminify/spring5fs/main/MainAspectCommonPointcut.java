package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtxWithCommonPointcut;
import org.seminify.spring5fs.spring.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspectCommonPointcut {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppCtxWithCommonPointcut.class);
        Calculator calculator = annotationConfigApplicationContext.getBean("calculator", Calculator.class);
        calculator.factorial(7);
        calculator.factorial(7);
        calculator.factorial(5);
        calculator.factorial(5);
        annotationConfigApplicationContext.close();
    }
}

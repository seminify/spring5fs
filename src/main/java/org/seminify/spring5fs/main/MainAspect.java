package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtx;
import org.seminify.spring5fs.spring.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppCtx.class);
        Calculator calculator = annotationConfigApplicationContext.getBean("calculator", Calculator.class);
        long fiveFact = calculator.factorial(5);
        System.out.println("cal.factorial(5) = " + fiveFact);
        System.out.println(calculator.getClass().getName());
        annotationConfigApplicationContext.close();
    }
}

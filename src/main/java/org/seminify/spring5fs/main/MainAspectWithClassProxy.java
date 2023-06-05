package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtxWithClassProxy;
import org.seminify.spring5fs.spring.Calculator;
import org.seminify.spring5fs.spring.RecCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspectWithClassProxy {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppCtxWithClassProxy.class);
        Calculator calculator = annotationConfigApplicationContext.getBean("calculator", RecCalculator.class);
        long fiveFact = calculator.factorial(5);
        System.out.println("calculator.factorial(5) = " + fiveFact);
        System.out.println(calculator.getClass().getName());
        annotationConfigApplicationContext.close();
    }
}

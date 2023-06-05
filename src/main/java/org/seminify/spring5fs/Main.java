package org.seminify.spring5fs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppContext.class);
        Greeter greeter = annotationConfigApplicationContext.getBean("greeter", Greeter.class);
        String msg = greeter.greet("스프링");
        System.out.println(msg);
        annotationConfigApplicationContext.close();
    }
}

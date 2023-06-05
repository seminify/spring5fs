package org.seminify.spring5fs;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppContext.class);
        Greeter greeter1 = annotationConfigApplicationContext.getBean("greeter", Greeter.class);
        Greeter greeter2 = annotationConfigApplicationContext.getBean("greeter", Greeter.class);
        System.out.println("(greeter1 == greeter2) = " + (greeter1 == greeter2));
        annotationConfigApplicationContext.close();
    }
}

package org.seminify.spring5fs.typehier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForType {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppCtx4Type.class);
        Printer printer1 = annotationConfigApplicationContext.getBean("consolePrinter", Printer.class);
        Printer printer2 = annotationConfigApplicationContext.getBean("consolePrinter", ConsolePrinter.class);
        System.out.println("printer1 == printer2 : " + (printer1 == printer2));
        annotationConfigApplicationContext.close();
    }
}

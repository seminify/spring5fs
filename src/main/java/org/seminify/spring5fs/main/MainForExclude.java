package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtxWithExclude;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForExclude {
    private static ApplicationContext applicationContext = null;

    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(AppCtxWithExclude.class);
    }
}

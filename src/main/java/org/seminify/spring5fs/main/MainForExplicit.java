package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtxWithExplicit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainForExplicit {
    private static AbstractApplicationContext abstractApplicationContext = null;

    public static void main(String[] args) {
        abstractApplicationContext = new AnnotationConfigApplicationContext(AppCtxWithExplicit.class);
        abstractApplicationContext.close();
    }
}

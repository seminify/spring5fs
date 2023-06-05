package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtxManual1;
import org.seminify.spring5fs.config.AppCtxManual2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainForManual {
    private static AbstractApplicationContext abstractApplicationContext = null;

    public static void main(String[] args) {
        abstractApplicationContext = new AnnotationConfigApplicationContext(AppCtxManual1.class, AppCtxManual2.class);
        abstractApplicationContext.close();
    }
}

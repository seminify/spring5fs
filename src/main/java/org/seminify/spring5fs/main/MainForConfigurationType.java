package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppConf1;
import org.seminify.spring5fs.config.AppConf2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainForConfigurationType {
    public static void main(String[] args) {
        AbstractApplicationContext abstractApplicationContext = new AnnotationConfigApplicationContext(AppConf1.class, AppConf2.class);
        AppConf1 appConf1 = abstractApplicationContext.getBean(AppConf1.class);
        System.out.println(appConf1 != null);
        abstractApplicationContext.close();
    }
}

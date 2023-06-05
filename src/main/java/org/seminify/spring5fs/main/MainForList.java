package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtxForList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MainForList {
    private static ApplicationContext applicationContext = null;

    public static void main(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(AppCtxForList.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        Arrays.asList(names).forEach(name -> System.out.println(name));
    }
}

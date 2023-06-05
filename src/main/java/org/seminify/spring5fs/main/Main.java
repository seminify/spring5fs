package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtx;
import org.seminify.spring5fs.spring.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext abstractApplicationContext = new AnnotationConfigApplicationContext(AppCtx.class);
        Client client = abstractApplicationContext.getBean("client", Client.class);
        client.send();
        abstractApplicationContext.close();
    }
}

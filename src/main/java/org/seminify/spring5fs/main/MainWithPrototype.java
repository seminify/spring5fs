package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.AppCtxWithPrototype;
import org.seminify.spring5fs.spring.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MainWithPrototype {
    public static void main(String[] args) {
        AbstractApplicationContext abstractApplicationContext = new AnnotationConfigApplicationContext(AppCtxWithPrototype.class);
        Client client1 = abstractApplicationContext.getBean(Client.class);
        Client client2 = abstractApplicationContext.getBean(Client.class);
        System.out.println("client1 == client2 : " + (client1 == client2));
        abstractApplicationContext.close();
    }
}

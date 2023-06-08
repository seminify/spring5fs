package org.seminify.spring5fs.config;

import org.seminify.spring5fs.spring.Client;
import org.seminify.spring5fs.spring.Client2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
    @Bean
    public Client client() {
        Client client = new Client();
        client.setHost("host");
        return client;
    }

    @Bean(initMethod = "connect", destroyMethod = "close")
    public Client2 client2() {
        Client2 client2 = new Client2();
        client2.setHost("host");
        return client2;
    }
}

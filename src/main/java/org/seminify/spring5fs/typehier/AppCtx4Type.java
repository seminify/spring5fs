package org.seminify.spring5fs.typehier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx4Type {
    @Bean
    public ConsolePrinter consolePrinter() {
        return new ConsolePrinter();
    }
}

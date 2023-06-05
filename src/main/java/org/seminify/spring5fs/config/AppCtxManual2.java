package org.seminify.spring5fs.config;

import org.seminify.spring5fs.spring2.MemberRegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtxManual2 {
    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService();
    }
}

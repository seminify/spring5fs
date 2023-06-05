package org.seminify.spring5fs.config;

import org.seminify.spring5fs.aspect.CacheAspect;
import org.seminify.spring5fs.aspect.ExeTimeAspect;
import org.seminify.spring5fs.spring.Calculator;
import org.seminify.spring5fs.spring.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppCtxWithCache {
    @Bean
    public CacheAspect cacheAspect() {
        return new CacheAspect();
    }

    @Bean
    public ExeTimeAspect exeTimeAspect() {
        return new ExeTimeAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}

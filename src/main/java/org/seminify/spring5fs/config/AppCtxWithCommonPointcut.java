package org.seminify.spring5fs.config;

import org.seminify.spring5fs.aspect2.CacheAspect2;
import org.seminify.spring5fs.aspect2.ExeTimeAspect2;
import org.seminify.spring5fs.spring.Calculator;
import org.seminify.spring5fs.spring.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppCtxWithCommonPointcut {
    @Bean
    public CacheAspect2 cacheAspect2() {
        return new CacheAspect2();
    }

    @Bean
    public ExeTimeAspect2 exeTimeAspect2() {
        return new ExeTimeAspect2();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}

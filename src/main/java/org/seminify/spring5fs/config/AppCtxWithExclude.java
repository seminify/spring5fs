package org.seminify.spring5fs.config;

import org.seminify.spring5fs.spring.MemberDao;
import org.seminify.spring5fs.spring.MemberPrinter;
import org.seminify.spring5fs.spring.MemberSummaryPrinter;
import org.seminify.spring5fs.spring.VersionPrinter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = {"org.seminify.spring5fs.spring", "org.seminify.spring5fs.spring2"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = NoProduct.class))
public class AppCtxWithExclude {
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    @Qualifier("memberPrinter")
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    @Qualifier("memberSummaryPrinter")
    public MemberPrinter memberSummaryPrinter() {
        return new MemberSummaryPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}

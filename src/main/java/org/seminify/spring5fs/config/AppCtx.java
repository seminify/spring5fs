package org.seminify.spring5fs.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.seminify.spring5fs.spring.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppCtx {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/root?characterEncoding=UTF8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(10);
        dataSource.setTestWhileIdle(true);
        dataSource.setMinEvictableIdleTimeMillis(60000 * 3);
        dataSource.setTimeBetweenEvictionRunsMillis(10 * 1000);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }

    @Bean
    public MemberRegisterService memberRegisterService() {
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePasswordService() {
        return new ChangePasswordService();
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }

    @Bean
    public MemberListPrinter memberListPrinter() {
        return new MemberListPrinter();
    }

    @Bean
    public MemberInfoPrinter memberInfoPrinter() {
        return new MemberInfoPrinter();
    }

    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}

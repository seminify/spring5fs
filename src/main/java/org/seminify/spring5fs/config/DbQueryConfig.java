package org.seminify.spring5fs.config;

import org.seminify.spring5fs.dbquery.DbQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbQueryConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    public DbQuery dbQuery() {
        return new DbQuery(dataSource);
    }
}

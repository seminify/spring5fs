package org.seminify.spring5fs.main;

import org.seminify.spring5fs.config.DbConfig;
import org.seminify.spring5fs.config.DbQueryConfig;
import org.seminify.spring5fs.dbquery.DbQuery;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainUsingDbQuery {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(DbConfig.class, DbQueryConfig.class);
        DbQuery dbQuery = annotationConfigApplicationContext.getBean(DbQuery.class);
        int count = dbQuery.count();
        System.out.println(count);
        annotationConfigApplicationContext.close();
    }
}

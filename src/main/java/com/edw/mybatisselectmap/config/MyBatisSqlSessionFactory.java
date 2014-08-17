package com.edw.mybatisselectmap.config;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {

    private static final SqlSessionFactory FACTORY;

    static {
        try {
            Reader reader = Resources.getResourceAsReader("com/edw/mybatisselectmap/sqlmap/Configuration.xml");
            FACTORY = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException("Fatal Error. Cause: " + e, e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return FACTORY;
    }
}

package com.acem.demo.db.config;

public class JdbcTemplate {

    public static <T> T process(DbExecutionWrapper<T> dbExecutionWrapper) {
        DbConnector dbConnector = new DbConnector();
        return dbExecutionWrapper.execute(dbConnector);
    }
}

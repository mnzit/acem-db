package com.acem.db.util;

public class JdbcTemplate {

    public static <T> T process(DbExecutionWrapper<T> dbExecutionWrapper) {
        DbConnector dbConnector = new DbConnector();
        return dbExecutionWrapper.execute(dbConnector);
    }
}

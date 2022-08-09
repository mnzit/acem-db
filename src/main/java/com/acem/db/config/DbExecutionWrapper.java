package com.acem.db.config;

public interface DbExecutionWrapper<T> {

    T execute(DbConnector dbConnector);
}

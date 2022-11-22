package com.acem.demo.db.config;

public interface DbExecutionWrapper<T> {

    T execute(DbConnector dbConnector);
}

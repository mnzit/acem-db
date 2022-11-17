package com.acem.demo.config;

public interface DbExecutionWrapper<T> {

    T execute(DbConnector dbConnector);
}

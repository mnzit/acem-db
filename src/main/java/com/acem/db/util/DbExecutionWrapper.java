package com.acem.db.util;

public interface DbExecutionWrapper<T> {

    T execute(DbConnector dbConnector);
}

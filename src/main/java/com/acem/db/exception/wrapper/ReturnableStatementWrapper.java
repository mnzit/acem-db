package com.acem.db.exception.wrapper;

@FunctionalInterface
public interface ReturnableStatementWrapper<T> {

    T execute() throws Exception;
}

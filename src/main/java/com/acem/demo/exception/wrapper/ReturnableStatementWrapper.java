package com.acem.demo.exception.wrapper;

@FunctionalInterface
public interface ReturnableStatementWrapper<T> {

    T execute() throws Exception;
}

package com.acem.demo.exception.wrapper;

@FunctionalInterface
public interface StatementWrapper {

    void execute() throws Exception;
}

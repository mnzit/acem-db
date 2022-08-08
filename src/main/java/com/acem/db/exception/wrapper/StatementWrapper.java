package com.acem.db.exception.wrapper;

@FunctionalInterface
public interface StatementWrapper {

    void execute() throws Exception;
}

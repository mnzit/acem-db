package com.acem.db.util;

@FunctionalInterface
public interface ReturnableCodeWrapper<T> {

    T execute() throws Exception;
}

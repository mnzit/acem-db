package com.acem.db.exception;

import com.acem.db.exception.wrapper.StatementWrapper;
import com.acem.db.exception.wrapper.ReturnableStatementWrapper;

public class ExceptionHandler {

    public static void handle(StatementWrapper statementWrapper) {
        try {
            statementWrapper.execute();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    public static void handle(StatementWrapper tryWrapper, StatementWrapper finallyWrapper) {
        try {
            tryWrapper.execute();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            try {
                finallyWrapper.execute();
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }


    public static <T> T handle(ReturnableStatementWrapper<T> tryWrapper, StatementWrapper finallyWrapper, T fallBackObject) {
        try {
            return tryWrapper.execute();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return fallBackObject;
        } finally {
            try {
                finallyWrapper.execute();
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }

    public static <T> T handleWithFallBack(ReturnableStatementWrapper<T> tryWrapper, T fallBackObject) {
        try {
            return tryWrapper.execute();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return fallBackObject;
        }
    }

    public static <T> T handle(ReturnableStatementWrapper<T> tryWrapper, StatementWrapper finallyWrapper) {
        return handle(tryWrapper, finallyWrapper, null);
    }

    public static <T> T handle(ReturnableStatementWrapper<T> returnableStatementWrapper) {
        try {
            return returnableStatementWrapper.execute();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return null;
        }
    }

    public <T> T handle(ReturnableStatementWrapper<T> returnableStatementWrapper, T fallBackObject) {
        try {
            return returnableStatementWrapper.execute();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return fallBackObject;
        }
    }
}

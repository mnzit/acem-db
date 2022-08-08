package com.acem.db.util;

public class ExceptionHandler {

    public static void handle(CodeWrapper codeWrapper) {
        try {
            codeWrapper.execute();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        }
    }

    public static void handle(CodeWrapper tryWrapper, CodeWrapper finallyWrapper) {
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


    public static <T> T handle(ReturnableCodeWrapper<T> tryWrapper, CodeWrapper finallyWrapper, T fallBackObject) {
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

    public static <T> T handle(ReturnableCodeWrapper<T> tryWrapper, CodeWrapper finallyWrapper) {
        return handle(tryWrapper, finallyWrapper, null);
    }


    public <T> T handle(ReturnableCodeWrapper<T> returnableCodeWrapper) {
        try {
            return returnableCodeWrapper.execute();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return null;
        }
    }

    public <T> T handle(ReturnableCodeWrapper<T> returnableCodeWrapper, T fallBackObject) {
        try {
            return returnableCodeWrapper.execute();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return fallBackObject;
        }
    }
}

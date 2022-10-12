package com.acem.db.utils;

import com.acem.db.exception.ExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
    public static ObjectMapper objectMapper = null;

    static {
        objectMapper = new ObjectMapper();
    }

    public static String toJson(Object object) {
        return ExceptionHandler
                .handleWithFallBack(
                        () -> objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object),
                        null
                );
    }
}

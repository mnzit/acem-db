package com.acem.demo.utils;

import jakarta.servlet.ServletInputStream;

public class InputStreamMapperUtil {

    public static <T> T mapToObject(ServletInputStream servletInputStream, Class<T> clazz){
        return JacksonUtil.toObject(servletInputStream, clazz);
    }
}

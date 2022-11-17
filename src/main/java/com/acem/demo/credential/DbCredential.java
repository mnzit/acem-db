package com.acem.demo.credential;

public interface DbCredential {

    String getIpAddress();

    String getPort();

    String getName();

    String getUsername();

    String getPassword();

    String getConfigValue(String key);
}

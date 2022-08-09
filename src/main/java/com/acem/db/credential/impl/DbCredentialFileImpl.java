package com.acem.db.credential.impl;

import com.acem.db.credential.DbCredential;
import com.acem.db.exception.ExceptionHandler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DbCredentialFileImpl implements DbCredential {
    private Map<String, String> configs = new HashMap();

    public DbCredentialFileImpl() {
        ExceptionHandler.handle(() -> {
            InputStream fileInputStream = getClass().getClassLoader().getResourceAsStream("db_credentials");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] configArray = line.split("=");
                String configKey = configArray[0];
                String configValue = configArray[1];
                configs.put(configKey, configValue);
            }
        });
    }

    @Override
    public String getIpAddress() {
        return configs.get("IP_ADDRESS");
    }

    @Override
    public String getPort() {
        return configs.get("PORT");
    }

    @Override
    public String getName() {
        return configs.get("NAME");
    }

    @Override
    public String getUsername() {
        return configs.get("USERNAME");
    }

    @Override
    public String getPassword() {
        return configs.get("PASSWORD");
    }

    @Override
    public String getConfigValue(String key) {
        return configs.get(key);
    }
}

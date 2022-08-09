package com.acem.db.util;

import com.acem.db.constant.DbConstant;
import com.acem.db.credential.DbCredential;
import com.acem.db.credential.impl.DbCredentialDotEnvImpl;
import com.acem.db.credential.impl.DbCredentialFileImpl;
import com.acem.db.mapper.RowMapper;
import com.acem.db.mapper.impl.StudentRowMapperImpl;
import com.acem.db.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {

    private Connection connection;
    private PreparedStatement statement;

    private DbCredential dbCredential;


    public DbUtil(DbCredential dbCredential) {
        this.dbCredential = dbCredential;
    }

    public DbUtil(){
        this.dbCredential = new DbCredentialDotEnvImpl();
    }

    public void connect() throws Exception {
        String url = "jdbc:mysql://" + dbCredential.getIpAddress() + ":" + dbCredential.getPort() + "/" + dbCredential.getName();
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(url, dbCredential.getUsername(), dbCredential.getPassword());
    }

    public void init(String sql) throws Exception {
        statement = connection.prepareStatement(sql);
    }

    public void connectAndInit(String sql) throws Exception {
        connect();
        init(sql);
    }

    public int executeUpdate() throws Exception {
        return statement.executeUpdate();
    }

    public ResultSet executeQuery() throws Exception {
        return statement.executeQuery();
    }

    public void close() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public <T> List<T> map(ResultSet resultSet, RowMapper<T> rowMapper) throws Exception {
        List<T> objects = new ArrayList<>();
        while (resultSet.next()) {
            T object = rowMapper.map(resultSet);
            objects.add(object);
        }
        return objects;
    }

    public <T> List<T> executeAndMap(RowMapper<T> rowMapper) throws Exception {
        return map(executeQuery(), rowMapper);
    }

    public void mapValue(Object... args) throws Exception {
        int noOfArgs = args.length;
        for (int i = 0; i < noOfArgs; i++) {
            statement.setObject(i + 1, args[0]);
        }
    }

    public <T> List<T> execute(String sql, RowMapper<T> mapper) throws Exception {
        connectAndInit(sql);
        return executeAndMap(mapper);
    }
}

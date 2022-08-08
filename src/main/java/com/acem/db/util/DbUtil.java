package com.acem.db.util;

import com.acem.db.constant.DbConstant;
import com.acem.db.mapper.RowMapper;
import com.acem.db.mapper.impl.StudentRowMapperImpl;
import com.acem.db.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbUtil {

    private Connection connection;
    private PreparedStatement statement;

    public void connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(DbConstant.URL, DbConstant.USERNAME, DbConstant.PASSWORD);
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

    public <T> List<T> executeAndMap(RowMapper<T> rowMapper) throws Exception {
        ResultSet resultSet = executeQuery();
        List<T> objects = new ArrayList<>();
        while (resultSet.next()) {
            T object = rowMapper.map(resultSet);
            objects.add(object);
        }
        return objects;
    }

    public void mapValue(Object... args) throws Exception {
        int noOfArgs = args.length;
        for (int i = 0; i < noOfArgs; i++) {
            statement.setObject(i + 1, args[0]);
        }
    }

    public <T> List<T> execute(String sql, RowMapper<T> mapper) throws Exception{
        connectAndInit(sql);
        return executeAndMap(mapper);
    }
}

package com.acem.demo.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T map(ResultSet resultSet) throws Exception;
}

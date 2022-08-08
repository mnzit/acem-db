package com.acem.db.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {

    T map(ResultSet resultSet) throws Exception;
}

package com.acem.db;


import com.acem.db.dao.StudentDao;
import com.acem.db.dao.impl.StudentDaoFileImpl;
import com.acem.db.dao.impl.StudentDaoMemoryImpl;
import com.acem.db.dao.impl.StudentDaoMySqlImpl;
import com.acem.db.model.Student;

import java.sql.Connection;
import java.sql.Driver;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoMySqlImpl();

        studentDao.delete(3L);
    }
}

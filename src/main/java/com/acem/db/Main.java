package com.acem.db;


import com.acem.db.dao.StudentDao;
import com.acem.db.dao.impl.StudentDaoMySqlImpl;
import com.acem.db.model.Student;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoMySqlImpl();

        Optional<List<Student>> students = studentDao.getAll();

        students.ifPresent(studentList -> studentList.stream().forEach(System.out::println));
    }
}

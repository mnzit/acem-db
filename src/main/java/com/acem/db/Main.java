package com.acem.db;


import com.acem.db.dao.StudentDao;
import com.acem.db.dao.impl.StudentDaoFileImpl;
import com.acem.db.dao.impl.StudentDaoMemoryImpl;
import com.acem.db.model.Student;

public class Main {
    public static void main(String[] args) {

        StudentDao studentDao = new StudentDaoFileImpl();


        studentDao.save(new Student());
    }
}

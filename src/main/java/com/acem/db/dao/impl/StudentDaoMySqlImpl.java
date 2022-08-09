package com.acem.db.dao.impl;

import com.acem.db.dao.StudentDao;
import com.acem.db.mapper.impl.StudentRowMapperImpl;
import com.acem.db.model.Student;
import com.acem.db.util.DbUtil;
import com.acem.db.exception.ExceptionHandler;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoMySqlImpl implements StudentDao {

    @Override
    public Optional<List<Student>> getAll() {
        DbUtil dbUtil = new DbUtil();
        return ExceptionHandler.handle(
                () -> {
                    String sql = "SELECT * FROM STUDENTS";
                    dbUtil.connectAndInit(sql);
                    ResultSet resultSet = dbUtil.executeQuery();
                    List<Student> students = new ArrayList<>();
                    while (resultSet.next()) {
                        Student student = new StudentRowMapperImpl().map(resultSet);
                        students.add(student);
                    }
                    return Optional.of(students);
                },
                () -> ExceptionHandler.handle(dbUtil::close),
                Optional.empty()
        );
    }

    @Override
    public Optional<Student> getById(Long id) {
        DbUtil dbUtil = new DbUtil();

        return ExceptionHandler.handle(()->{
                dbUtil.connect();

                String sql = "SELECT * FROM STUDENTS WHERE ID = ?";
                dbUtil.init(sql);
                dbUtil.mapValue(id);
                ResultSet resultSet = dbUtil.executeQuery();
                while (resultSet.next()) {
                    Student student = new StudentRowMapperImpl().map(resultSet);
                    return Optional.of(student);
                }
                return Optional.empty();
        },
                ()->ExceptionHandler.handle(dbUtil::close)
                ,Optional.empty()
        );

    }


    @Override
    public Optional<Student> getByEmailAddress(String emailAddress) {
        DbUtil dbUtil = new DbUtil();

        return ExceptionHandler.handle(()->{
                    dbUtil.connect();

                    String sql = "SELECT * FROM STUDENTS WHERE EMAIL = ?";
                    dbUtil.init(sql);
                    dbUtil.mapValue(emailAddress);

                    ResultSet resultSet = dbUtil.executeQuery();

                    while (resultSet.next()) {
                        Student student = new StudentRowMapperImpl().map(resultSet);
                        return Optional.of(student);
                    }

                    return Optional.empty();
        },
                ()->ExceptionHandler.handle(dbUtil::close)
                ,Optional.empty()
        );

    }

    @Override
    public Optional<Student> getByContactNo(String contactNo) {
        DbUtil dbUtil = new DbUtil();

        return ExceptionHandler.handle(()->{
                    dbUtil.connect();

                    String sql = "SELECT * FROM STUDENTS WHERE CONTACT_NO = ?";
                    dbUtil.init(sql);
                    dbUtil.mapValue(contactNo);

                    ResultSet resultSet = dbUtil.executeQuery();

                    while (resultSet.next()) {
                        Student student = new StudentRowMapperImpl().map(resultSet);
                        return Optional.of(student);
                    }

                    return Optional.empty();
        },
                ()->ExceptionHandler.handle(dbUtil::close)
                ,Optional.empty()
        );

    }

    @Override
    public Boolean save(Student student) {
        DbUtil dbUtil = new DbUtil();

        try {
            dbUtil.connect();

            String sql = "INSERT INTO STUDENTS(NAME, EMAIL, CONTACT_NO) VALUES (?,?,?)";
            dbUtil.init(sql);
            dbUtil.mapValue(student.getName(), student.getEmail(), student.getContactNo());

            int rowsAffected = dbUtil.executeUpdate();
            System.out.println("rowsAffected: " + rowsAffected);
            if (rowsAffected >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return false;
        } finally {
            try {
                dbUtil.close();
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }

    @Override
    public Boolean update(Student student) {
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.connect();
            String sql = "UPDATE STUDENTS SET NAME=?, EMAIL=?, CONTACT_NO=? WHERE ID=?";
            dbUtil.init(sql);
            dbUtil.mapValue(student.getName(), student.getEmail(), student.getContactNo(), student.getId());
            int rowsAffected = dbUtil.executeUpdate();
            System.out.println("rowsAffected: " + rowsAffected);
            if (rowsAffected >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return false;
        } finally {
            try {
                dbUtil.close();
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }

    @Override
    public Boolean delete(Long id) {
        DbUtil dbUtil = new DbUtil();
        try {
            dbUtil.connect();
            String sql = "DELETE FROM STUDENTS WHERE ID = ?";
            dbUtil.init(sql);
            dbUtil.mapValue(id);
            int rowsAffected = dbUtil.executeUpdate();
            System.out.println("rowsAffected: " + rowsAffected);
            if (rowsAffected >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return false;
        } finally {
            try {
                dbUtil.close();
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }
}

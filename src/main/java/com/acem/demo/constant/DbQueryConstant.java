package com.acem.demo.constant;

public interface DbQueryConstant {

    interface Student {
        String GET_ALL = "SELECT * FROM STUDENTS";
        String GET_BY_ID = "SELECT * FROM STUDENTS WHERE ID = ?";
        String GET_BY_EMAIL = "SELECT * FROM STUDENTS WHERE EMAIL = ?";
        String GET_BY_CONTACT_NO = "SELECT * FROM STUDENTS WHERE CONTACT_NO = ?";
        String SAVE = "INSERT INTO STUDENTS(NAME, EMAIL, CONTACT_NO) VALUES (?,?,?)";
        String UPDATE = "UPDATE STUDENTS SET NAME=?, EMAIL=?, CONTACT_NO=? WHERE ID=?";
        String DELETE = "DELETE FROM STUDENTS WHERE ID = ?";
    }
}

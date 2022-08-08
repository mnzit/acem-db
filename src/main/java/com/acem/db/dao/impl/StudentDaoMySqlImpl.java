package com.acem.db.dao.impl;

import com.acem.db.dao.StudentDao;
import com.acem.db.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDaoMySqlImpl implements StudentDao {

    @Override
    public Optional<List<Student>> getAll() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/COLLEGE";
            String username = "root";
            String password = "Root@12345";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM STUDENTS";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getLong("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setContactNo(resultSet.getString("CONTACT_NO"));

                students.add(student);
            }
            return Optional.of(students);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return Optional.empty();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }

    @Override
    public Optional<Student> getById(Long id) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/COLLEGE";
            String username = "root";
            String password = "Root@12345";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM STUDENTS WHERE ID = " + id;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getLong("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setContactNo(resultSet.getString("CONTACT_NO"));

                return Optional.of(student);
            }

            return Optional.empty();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return Optional.empty();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }


    @Override
    public Optional<Student> getByEmailAddress(String emailAddress) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/COLLEGE";
            String username = "root";
            String password = "Root@12345";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM STUDENTS WHERE EMAIL = " + emailAddress;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getLong("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setContactNo(resultSet.getString("CONTACT_NO"));

                return Optional.of(student);
            }

            return Optional.empty();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return Optional.empty();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }

    @Override
    public Optional<Student> getByContactNo(String contactNo) {

        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/COLLEGE";
            String username = "root";
            String password = "Root@12345";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "SELECT * FROM STUDENTS WHERE CONTACT_NO = " + contactNo;
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student student = new Student();

                student.setId(resultSet.getLong("ID"));
                student.setName(resultSet.getString("NAME"));
                student.setEmail(resultSet.getString("EMAIL"));
                student.setContactNo(resultSet.getString("CONTACT_NO"));

                return Optional.of(student);
            }

            return Optional.empty();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            return Optional.empty();
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }

    @Override
    public Boolean save(Student student) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/COLLEGE";
            String username = "root";
            String password = "Root@12345";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "INSERT INTO STUDENTS(NAME, EMAIL, CONTACT_NO) VALUES ('%s','%s','%s')";
            sql = String.format(sql, student.getName(), student.getEmail(), student.getContactNo());
            System.out.println(sql);
            int rowsAffected = statement.executeUpdate(sql);
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
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }

    @Override
    public Boolean update(Student student) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/COLLEGE";
            String username = "root";
            String password = "Root@12345";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "UPDATE STUDENTS SET NAME='%s',EMAIL='%s',CONTACT_NO='%s' WHERE ID=%s";
            sql = String.format(sql, student.getName(), student.getEmail(), student.getContactNo(), student.getId());
            System.out.println(sql);
            int rowsAffected = statement.executeUpdate(sql);
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
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }

    @Override
    public Boolean delete(Long id) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/COLLEGE";
            String username = "root";
            String password = "Root@12345";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "DELETE FROM STUDENTS WHERE ID=%s";
            sql = String.format(sql, id);
            System.out.println(sql);
            int rowsAffected = statement.executeUpdate(sql);
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
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (Exception ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }
}

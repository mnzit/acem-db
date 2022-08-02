package com.acem.db.dao;

import com.acem.db.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    Optional<List<Student>> getAll();

    Optional<Student> getById(Long id);

    Optional<Student> getByEmailAddress(String emailAddress);

    Optional<Student> getByContactNo(String contactNo);

    Boolean save(Student student);

    Boolean update(Student student);

    Boolean delete(Long id);
}

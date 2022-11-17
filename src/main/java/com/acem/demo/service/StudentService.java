package com.acem.demo.service;

import com.acem.demo.model.Student;
import com.acem.demo.response.Response;


public interface StudentService {

    Response getAll();

    Response getById(Long id);

    Response getByEmailAddress(String emailAddress);

    Response getByContactNo(String contactNo);

    Response save(Student student);

    Response update(Student student);

    Response delete(Long id);
}

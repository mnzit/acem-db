package com.acem.db.controller;

import com.acem.db.dao.StudentDao;
import com.acem.db.dao.impl.StudentDaoMySqlImpl;
import com.acem.db.exception.ExceptionHandler;
import com.acem.db.model.Student;
import com.acem.db.utils.JacksonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class StudentController extends HttpServlet {

    private final StudentDao studentDao = new StudentDaoMySqlImpl();

    @Override
    public void init() throws ServletException {
        System.out.println("Student Controller init called");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        Optional<List<Student>> optionalStudentList = studentDao.getAll();
        if (optionalStudentList.isPresent() && !optionalStudentList.isEmpty()) {
            List<Student> students = optionalStudentList.get();
            response.setContentType("application/json");
            response.setStatus(200);
            String responseBody = JacksonUtil.toJson(students);
            if (responseBody != null) {
                writer.write(responseBody);
            } else {
                response.setStatus(500);
            }
        } else {
            response.setStatus(404);
        }
    }
}

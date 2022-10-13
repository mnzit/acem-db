package com.acem.db.controller;

import com.acem.db.builder.ResponseBuilder;
import com.acem.db.constant.RegexConstant;
import com.acem.db.constant.ResponseMessageConstant;
import com.acem.db.dao.StudentDao;
import com.acem.db.dao.impl.StudentDaoMySqlImpl;
import com.acem.db.exception.ExceptionHandler;
import com.acem.db.model.Student;
import com.acem.db.response.Response;
import com.acem.db.service.StudentService;
import com.acem.db.service.impl.StudentServiceImpl;
import com.acem.db.utils.JacksonUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


public class StudentController extends Controller {

    private static final StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        ExceptionHandler.handleWithFallBack(
            () -> {
                String url = request.getRequestURL().toString();
                String[] urlTokenized = url.split("/");
                String id = urlTokenized[urlTokenized.length - 1];
                Response responseBody = null;
                if (id.matches(RegexConstant.isNumber)) {
                    responseBody = studentService.getById(Long.parseLong(id));
                } else {
                    responseBody = studentService.getAll();
                }
                buildResponse(response, responseBody);
            },
            () -> buildResponse(response, ResponseBuilder.serverError())
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ExceptionHandler.handleWithFallBack(
            () -> {
                ServletInputStream servletInputStream = request.getInputStream();
                Student student = JacksonUtil.toObject(servletInputStream, Student.class);
                Response responseBody = studentService.save(student);
                buildResponse(response, responseBody);
            },
            () -> buildResponse(response, ResponseBuilder.serverError())
        );
    }
}

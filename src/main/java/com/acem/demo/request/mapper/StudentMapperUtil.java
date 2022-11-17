package com.acem.demo.request.mapper;

import com.acem.demo.model.Student;
import com.acem.demo.request.StudentSaveRequest;
import com.acem.demo.request.StudentUpdateRequest;
import com.acem.demo.utils.ModalMapperUtil;

public class StudentMapperUtil {

    public static Student mapStudent(StudentSaveRequest studentSaveRequest) {
        return ModalMapperUtil.map(studentSaveRequest, Student.class);
    }

    public static Student mapStudent(StudentUpdateRequest studentUpdateRequest) {
        return ModalMapperUtil.map(studentUpdateRequest, Student.class);
    }
}

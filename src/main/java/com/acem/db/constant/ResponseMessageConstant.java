package com.acem.db.constant;

public interface ResponseMessageConstant {

    interface Student {
        String ONE = "Student fetched successfully";
        String ALL = "Students fetched successfully";
        String NOT_FOUND = "Students not found";
        String SAVED = "Student saved successfully";
        String NOT_SAVED = "Student not saved";


    }

    interface Teacher {

    }

    String SERVER_ERROR = "Server Error";
}

package com.acem.demo.providers;

import com.acem.demo.constant.ResponseMessageConstant;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.List;
import java.util.stream.Collectors;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {

        List<String> violations = exception.getConstraintViolations().stream()
                .map(constraintViolation -> constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage())
                .collect(Collectors.toList());

        com.acem.demo.response.Response responseBody = new com.acem.demo.response.Response()
                .success(false)
                .error(violations)
                .description(ResponseMessageConstant.INVALID_REQUEST_BODY)
                .statusCode(HttpServletResponse.SC_BAD_REQUEST);

        return Response
                .status(responseBody.getStatusCode())
                .entity(responseBody)
                .build();

    }
}

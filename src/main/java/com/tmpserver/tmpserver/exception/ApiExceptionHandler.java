package com.tmpserver.tmpserver.exception;

import com.tmpserver.tmpserver.response.ApiResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ApiExceptionHandler {

    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ApiResponse> handleBindException(BindException ex, HttpServletRequest request) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        ApiResponse response = new ApiResponse(BAD_REQUEST, request);
        response.setErrors(getErrorsMap(errors));

        return new ResponseEntity<>(response, BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse> handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        ApiResponse response = new ApiResponse(BAD_REQUEST, request);
        response.setErrors(getExceptionMap(ex));

        return new ResponseEntity<>(response, BAD_REQUEST);
    }

    private Map<String, String> getErrorsMap(List<FieldError> errors) {
        Map<String, String> errorMap = new HashMap<>();

        for(FieldError error : errors) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }

        return errorMap;
    }

    private Map<String, String> getExceptionMap(RuntimeException ex) {
        Map<String, String> errorMap = new HashMap<>();

        errorMap.put(ex.getClass().getName(), ex.getMessage());
        return errorMap;
    }

}

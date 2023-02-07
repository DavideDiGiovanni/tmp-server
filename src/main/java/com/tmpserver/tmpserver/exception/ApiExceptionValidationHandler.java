package com.tmpserver.tmpserver.exception;

import com.tmpserver.tmpserver.response.ApiResponseValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ApiExceptionValidationHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseValidationError> handleValidationErrors(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();

        ApiResponseValidationError response = new ApiResponseValidationError(
                errors
        );

        response.setPath(request.getRequestURI());

        return new ResponseEntity<>(response, response.getStatus());
    }

}

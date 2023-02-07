package com.tmpserver.tmpserver.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data @NoArgsConstructor @AllArgsConstructor
public class ApiResponseValidationError extends ApiResponse {

    private Map<String, String> errors;

    public ApiResponseValidationError(List<FieldError> errorList) {
        super(HttpStatus.BAD_REQUEST);
        errors = getErrorsMap(errorList);
    }

    private Map<String, String> getErrorsMap(List<FieldError> errors) {
        Map<String, String> errorMap = new HashMap<>();

        for(FieldError error : errors) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }

        return errorMap;
    }
}

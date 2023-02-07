package com.tmpserver.tmpserver.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data @NoArgsConstructor @AllArgsConstructor
public class ApiResponseError extends ApiResponse {

    private Class error;
    private String message;

    public ApiResponseError(Exception exception) {
        super(HttpStatus.BAD_REQUEST);
        error = exception.getClass();
        message = exception.getLocalizedMessage();
    }
}

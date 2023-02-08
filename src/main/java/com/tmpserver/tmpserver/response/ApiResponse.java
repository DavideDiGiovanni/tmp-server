package com.tmpserver.tmpserver.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor @NoArgsConstructor @Data
public class ApiResponse {

    private Instant timestamp;
    private int statusCode;
    private String status;
    private String path;
    private Map<String, String> errors;
    private Object message;

    public ApiResponse(HttpStatus httpStatus, HttpServletRequest request) {
        timestamp = Instant.now();
        statusCode = httpStatus.value();
        status = httpStatus.name();
        path = request.getRequestURI();
    }
}

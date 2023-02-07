package com.tmpserver.tmpserver.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor @NoArgsConstructor @Data
public class ApiResponse {

    private Instant timestamp;
    private HttpStatus status;
    private String path;

    public ApiResponse(HttpStatus httpStatus) {
        timestamp = Instant.now();
        status = httpStatus;
    }
}

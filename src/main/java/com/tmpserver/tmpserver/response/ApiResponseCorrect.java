package com.tmpserver.tmpserver.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data @NoArgsConstructor
public class ApiResponseCorrect extends ApiResponse {

    private Object message;

    public ApiResponseCorrect(Object message) {
        super(HttpStatus.OK);
        this.message = message;
    }

}

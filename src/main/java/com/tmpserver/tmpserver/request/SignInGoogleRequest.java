package com.tmpserver.tmpserver.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Data
public class SignInGoogleRequest {

    @NotBlank @NotEmpty
    private String jwt;
}

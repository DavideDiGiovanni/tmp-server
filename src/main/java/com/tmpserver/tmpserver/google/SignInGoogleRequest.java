package com.tmpserver.tmpserver.google;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Data
public class SignInGoogleRequest {

    @NotBlank @NotEmpty
    private String jwt;
}

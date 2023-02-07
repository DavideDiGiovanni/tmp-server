package com.tmpserver.tmpserver.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class SignUpRequest {

    @Email
    @Size(max=120, min=6)
    @NotBlank @NotEmpty
    private String email;

    @Size(max=12, min=3)
    @NotBlank @NotEmpty
    private String name;

    @Size(max=12, min=3)
    @NotBlank @NotEmpty
    private String familyName;

    @Size(max=32, min=8)
    @NotBlank @NotEmpty
    private String password;

}

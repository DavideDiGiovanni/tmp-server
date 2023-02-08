package com.tmpserver.tmpserver.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class User {

    private String email;
    private String name;
    private String familyName;
    private String password;
}

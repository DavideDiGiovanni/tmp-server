package com.tmpserver.tmpserver.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class User {

    @Id
    @Column(length = 100)
    private String email;
    private String name;
    private String familyName;
    private String password;
}

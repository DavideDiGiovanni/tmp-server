package com.tmpserver.tmpserver.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class User {

    @Id
    private String email;
    private String name;
    private String familyName;
    private String password;
}

package com.tmpserver.tmpserver.google;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class GoogleUserDTO {
    public String iss;
    public int nbf;
    public String aud;
    public String sub;
    public String hd;
    public String email;
    public boolean email_verified;
    public String azp;
    public String name;
    public String picture;
    public String given_name;
    public String family_name;
    public int iat;
    public int exp;
    public String jti;
}

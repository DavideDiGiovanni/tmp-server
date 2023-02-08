package com.tmpserver.tmpserver.google;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class GoogleService {

    public GoogleUserDTO getUser(String jwtToken) {

        String[] chunks = jwtToken.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();

        String payload = new String(decoder.decode(chunks[1]));

        GoogleUserDTO googleUserDTO;
        ObjectMapper om = new ObjectMapper();

        try {
            googleUserDTO = om.readValue(payload, GoogleUserDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return googleUserDTO;
    }
}

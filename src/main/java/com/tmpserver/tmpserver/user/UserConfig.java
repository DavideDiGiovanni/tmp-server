package com.tmpserver.tmpserver.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User davide = new User(
                    "davide.digiovanni@sysconsgroup.com",
                    "Davide",
                    "Di Giovanni",
                    "password12"
            );

            User marco = new User(
                    "marco.baratto@sysconsgroup.com",
                    "Marco",
                    "Baratto",
                    "password34"
            );

            repository.saveAll(
                    List.of(davide, marco)
            );
        };
    }
}

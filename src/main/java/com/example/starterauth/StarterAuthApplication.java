package com.example.starterauth;

import com.example.starterauth.data.entity.AppUser;
import com.example.starterauth.data.entity.AppUserRole;
import com.example.starterauth.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class StarterAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterAuthApplication.class, args);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}

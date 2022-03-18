package com.delly.delly;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.BeanProperty;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class DellyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DellyApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Algorithm JWTAlgorithm() { return Algorithm.HMAC256("secret".getBytes(StandardCharsets.UTF_8));}
}

package com.cleaningegneria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

@SpringBootApplication(exclude = R2dbcAutoConfiguration.class)
public class CleanIngegneriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanIngegneriaApplication.class, args);
    }

}
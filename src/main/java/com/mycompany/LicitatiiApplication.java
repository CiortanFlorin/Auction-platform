package com.mycompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LicitatiiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LicitatiiApplication.class, args);
    }

}

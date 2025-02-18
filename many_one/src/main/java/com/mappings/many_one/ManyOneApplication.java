package com.mappings.many_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mappings.many_one")
public class ManyOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManyOneApplication.class, args);
    }

}

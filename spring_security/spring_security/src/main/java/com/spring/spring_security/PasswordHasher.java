package com.spring.spring_security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode("sai@2003");
        System.out.println("BCrypt Hashed Password: " + hashedPassword);
    }
}
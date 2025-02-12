//package com.spring.spring_security.service;
//
//import java.sql.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.stereotype.Service;
//
//import io.jsonwebtoken.Jwts;
//
//@Service
//public class JWTService {
//
//	public String generateToken(String name) {
//		Map<String,Object> claims=new HashMap<>();
//		return Jwts.builder()
//				.claims()
//				.add(claims)
//				.subject(name)
//				.issuedAt(new Date(System.currentTimeMillis()))
//				.expiration(new Date(System.currentTimeMillis()*60*60*30))
//				.and()
//				.signWith()
//				.compact();
//		return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IlJhbSIsImlhdCI6MTUxNjIzOTAyMn0.tMB_t1eIxDGiX-HbWubo76QY0tlKIlIvmrwlZOuDtX8";
//	}
//	
//}

//package com.FinalProject.FYear.Model;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//
//@Component
//public class JwtTokenUtil {
//
//    private final String secretKey = "ismael"; // Replace with your own secret key
//    private final long expirationMs = 86400000; // 24 hours
//
//    public String generateToken(Long userId) {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + expirationMs);
//
//        return Jwts.builder()
//                .setSubject(userId.toString())
//                .setIssuedAt(now)
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }
//
//    public Long getUserIdFromToken(String token) {
//        Jws<Claims> claimsJws = Jwts.parser()
//                .setSigningKey(secretKey)
//                .parseClaimsJws(token);
//
//        return Long.parseLong(claimsJws.getBody().getSubject());
//    }
//}

package com.example.jwtapp01.utility;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	
	private static final String SECRET_KEY = "mysecretkey12345mysecretkey12345mysecretkey12345";

    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5)) // 5 minutes
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("Token Expired");
        } catch (JwtException e) {
            System.out.println("Invalid Token");
        }
        return false;
    }
}
	
//	private static final String SECRET_KEY = "mysecretkey12345mysecretkey12345mysecretkey12345";
//
//	public static String generateToken(String username) {
//
//		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
//				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 1)) // 5 mins
//				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
//	}
//
//	public static String extractUsername(String token) {
//		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
//	}
//
//	public static boolean validateToken(String token) {
//		try {
//			Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//}
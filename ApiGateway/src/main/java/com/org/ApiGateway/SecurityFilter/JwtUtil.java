package com.org.ApiGateway.SecurityFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {
    private final String SECRET = "welcometoApnaMartApnamartApnaMArtApnamartapnamart"; // same secret as user service
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public Claims validateToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
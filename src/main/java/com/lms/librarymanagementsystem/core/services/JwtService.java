package com.lms.librarymanagementsystem.core.services;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	@Value("${jwt.expiration}")
    private long EXPIRATION;
	
    @Value("${jwt.key}")
    private String SECRET_KEY;
    
    public String generateToken(String userName, Map<String, Object> extraClaims) {
        return Jwts
                .builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .claims(extraClaims)
                .subject(userName)
                .signWith(getSignKey())
                .compact();
    }
    
    public Boolean validateToken(String token)
    {
        return getClaimsFromToken(token).getExpiration().after(new Date());
    }
    public String extractUsername(String token)
    {
        return getClaimsFromToken(token).getSubject();
    }
    
    private Claims getClaimsFromToken(String token)
    {
        SecretKey key = (SecretKey) getSignKey();
        return Jwts
                .parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}

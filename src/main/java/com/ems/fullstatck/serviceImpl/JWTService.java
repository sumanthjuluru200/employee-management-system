package com.ems.fullstatck.serviceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private String secretKey = "cF781A";

    public JWTService() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        secretKey = Base64.getEncoder().encodeToString(keyGenerator.generateKey().getEncoded());
    }

    public String generateToken(String username) {

        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 100 * 60 * 10))
                .signWith(getKey())
                .compact();
    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

}

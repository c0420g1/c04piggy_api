package com.example.demo.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

public class TokenAuthenticator {
    private static final long EXPIRATION_TIME = 7 * 24 * 60 * 60 * 1000;  // 7 days
    private static final String AUTH_HEADER_STRING = "Authorization";
    private static final String AUTHORIZATIONS_STRING = "role";

    static String secret = "C0420G1Cinemadhfjksdkhdjfkhjskdfhjhsdfkljhsdfklttteeeee";

    static Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
            SignatureAlgorithm.HS256.getJcaName());

    public static String addAuthentication( String userName, String autorizations) {
        String jwt = Jwts.builder()
                .setSubject(userName)
                .claim(AUTHORIZATIONS_STRING, autorizations)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(hmacKey)
                .compact();
        return jwt;
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(AUTH_HEADER_STRING);
        if (token != null) {
            Jws<Claims> jwt = Jwts.parserBuilder()
                    .setSigningKey(hmacKey)
                    .build()
                    .parseClaimsJws(token);

            Claims body = jwt.getBody();
            String userName = body.getSubject();

            final String credentials =  body.get(AUTHORIZATIONS_STRING).toString();
            return userName != null ?
                    new UsernamePasswordAuthenticationToken(userName, credentials, Collections.emptyList()) :
                    null;
        }
        return null;
    }
}

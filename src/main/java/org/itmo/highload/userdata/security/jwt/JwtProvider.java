package org.itmo.highload.userdata.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtProvider {

    private String secret;

    public String generateToken(String login) {
        return JWT.create()
                .withSubject("User Details")
                .withClaim("login", login)
                .withIssuedAt(new Date())
                .withIssuer("High Load")
                .sign(Algorithm.HMAC256(secret));
    }

    public String validateTokenAndRetrieveSubject (String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User Details")
                .withIssuer("High Load")
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("login").asString();
    }
}
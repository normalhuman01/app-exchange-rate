package pe.com.test.challenge.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
@Slf4j
public class JwtProvider {

    private String secret = "challengetcschallengetcschallengetcschallengetcschallengetcschallengetcs";
    private Integer expiration = 3600;

    private SecretKey getKey(String secret) {

        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secret));
    }

    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(getKey(secret))
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parser().verifyWith(getKey(secret)).build().parseSignedClaims(token).getPayload();
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public Date getExpirationDate(String token) {
        return getClaims(token).getExpiration();
    }

    public Boolean verify(String token) {
        return getClaims(token).getExpiration().after(new Date());
    }

}

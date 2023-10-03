package pe.edu.upc.aaw.api_examen1_final_202113835.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil implements Serializable {
    private static final long hryeSerialVersionUID = -2550185165626007488L;

    //milisegundos || 18 minutos, le quitamos mil 18 segundos demo
    public static final long HRYE_JWT_TOKEN_VALIDITY = 7 * 60 * 60 * 1000;

    @Value("${jwt.secret}")
    private String hryeSecret;

    //retrieve username from jwt token
    public String getUsernameFromToken(String hryeToken) {
        return getClaimFromToken(hryeToken, Claims::getSubject);
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String hryeToken) {
        return getClaimFromToken(hryeToken, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String hryeToken, Function<Claims, T> hryeClaimsResolver) {
        final Claims hryeClaims = getAllClaimsFromToken(hryeToken);
        return hryeClaimsResolver.apply(hryeClaims);
    }
    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String hryeToken) {
        return Jwts.parser().setSigningKey(hryeSecret).parseClaimsJws(hryeToken).getBody();
    }

    //check if the token has expired
    private Boolean isTokenExpired(String hryeToken) {
        final Date hryeExpiration = getExpirationDateFromToken(hryeToken);
        return hryeExpiration.before(new Date());
    }

    //generate token for user
    public String generateToken(UserDetails hryeUserDetails) {
        Map<String, Object> hryeClaims = new HashMap<>();
        hryeClaims.put("nombre", "rosa");
        hryeClaims.put("role",hryeUserDetails.getAuthorities().stream().map(r->r.getAuthority()).collect(Collectors.joining()));
        return doGenerateToken(hryeClaims, hryeUserDetails.getUsername());
    }

    //while creating the token -
    //1. Define  claims of the token, like Issuer, Expiration, Subject, and the ID
    //2. Sign the JWT using the HS512 algorithm and secret key.
    //3. According to JWS Compact Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
    //   compaction of the JWT to a URL-safe string
    private String doGenerateToken(Map<String, Object> hryeClaims, String hryeSubject) {

        return Jwts.builder().setClaims(hryeClaims).setSubject(hryeSubject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + HRYE_JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, hryeSecret).compact();
    }

    //validate token
    public Boolean validateToken(String hryeToken, UserDetails hryeUserDetails) {
        final String hryeUsername = getUsernameFromToken(hryeToken);
        return (hryeUsername.equals(hryeUserDetails.getUsername()) && !isTokenExpired(hryeToken));
    }
}

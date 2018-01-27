package com.chase.chaseservice.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.chase.chaseservice.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtAuthorization {

    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String SECRET = "ACFSTHAITRACESKEY";
    public static final String TOKEN_PREFIX = "Bearer ";

    public String generateJwtToken(UserDto user) throws Exception {
        String token =
                Jwts.builder().setClaims(getClaim(user)).setIssuer("ThaiTraces")
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                        .setId(user.getUserId()).signWith(SignatureAlgorithm.HS512, SECRET).compact();
        return token;
    }


    private Map<String, Object> getClaim(UserDto user) {
        Map claim = new ObjectMapper().convertValue(user, Map.class);
        return claim;
    }

    public HashMap<String,Object> verifyToken(String token) throws Exception {
        HashMap<String,Object> result =new HashMap<String,Object>();
        try {
            Claims claim = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            Date expDate = claim.getExpiration();
            if(expDate.before(new Date())){
                result.put("verifyStatus","N");
                result.put("verifyMessage","Token Expired");
            }
            else{
                result.put("verifyStatus","Y");
                result.put("verifyMessage","Pass");
            }
        } catch (SignatureException e) {
            result.put("verifyStatus","N");
            result.put("verifyMessage","Invalid Token");
        }
        return result;
    }
}


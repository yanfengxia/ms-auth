package com.beta.ms.auth.service;

import com.beta.ms.auth.entity.UserEntity;
import com.beta.ms.auth.model.Token;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;

@Service
@Slf4j
public class TokenService {

    @Value("${key}")
    private String key;

//    @CachePut(value = "token", key = "#result.token")
    public Token createNewToken(UserEntity userEntity) throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        Date now = new Date();
        Date expiry = DateUtils.addHours(now, 1);
        try {
            Token token = Token.builder()
                    .createTime(now)
                    .expiryTime(expiry)
                    .expiryIn(3600)
                    .token(generateJWT(userEntity.getUsername(), now, expiry))
                    .user(userEntity)
                    .build();
            return token;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    private String generateJWT(String subject, Date issueDate, Date expiryDate) throws InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            return Jwts.builder()
                    .claim("modules", new ArrayList<String>(){{
                        add("sales");
                        add("product");
                    }})
                    .claim("roles", new ArrayList<String>(){{
                        add("CUSTOMER_SERVICE_REPRESENTATIVE");
                        add("CUSTOMER_SERVICE_MANAGER");
                    }})
                    .setSubject(subject)
                    .setIssuedAt(issueDate)
                    .setExpiration(expiryDate)
                    .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(key)))
                    .compact();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }
}

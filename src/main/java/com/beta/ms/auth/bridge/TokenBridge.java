package com.beta.ms.auth.bridge;

import com.beta.ms.auth.model.Token;
import com.beta.ms.auth.ro.TokenRO;
import org.springframework.stereotype.Component;

@Component
public class TokenBridge {
    public TokenRO convertTokenToTokenRO(Token token) {
        return TokenRO.builder()
                .token(token.getToken())
                .expiretime(token.getExpiryTime())
                .expiryin(token.getExpiryIn())
                .build();
    }
}

package com.glcxw.avatar.security.token.service;

import com.glcxw.avatar.security.context.Authentication;
import com.glcxw.avatar.security.token.AccessTokenServices;
import com.glcxw.avatar.security.token.AccessTokenStore;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Date;

public class DefaultAccessTokenServices implements AccessTokenServices {

    private static final Logger logger = LoggerFactory.getLogger(DefaultAccessTokenServices.class);

    private static final String REGEX = ";";

    private static final String SECRET_KEY = "JANETTE_SECRET_KEY";

    private static final String token_key = "USER_INFO::";

    private static final Long EXPIRATION_IN = 60L * 60L * 24L * 1000L;

    @Getter
    protected final AccessTokenStore tokenStore;

    public DefaultAccessTokenServices() {
        this.tokenStore = new InMemoryAccessTokenStore();
    }

    public DefaultAccessTokenServices(AccessTokenStore tokenStore) {
        Assert.notNull(tokenStore, "tokenStore required");
        this.tokenStore = tokenStore;
    }

    @Override
    public Authentication loadAuthentication(String token) {
        Assert.notNull(token, "token not null!");
        String subject = null;
        try {
            subject = Jwts.parser().setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token).getBody().getSubject();
        } catch (Exception e) {
            logger.error("parseClaimsJws token error", e);
        }
        if (subject == null) {
            return null;
        } else {
            Class<? extends Authentication> authClass;
            try {
                authClass = extractSubjectAuthClass(subject);
            } catch (Exception e) {
                throw new IllegalStateException("extractSubjectAuthClass error", e);
            }
            return tokenStore.readAuthentication(token_key + subject, authClass);
        }
    }

    @Override
    public String createAccessToken(Authentication authentication) {
        return createAccessToken(authentication, EXPIRATION_IN);
    }

    @Override
    public String createAccessToken(Authentication authentication, long expirationIn) {
        Assert.notNull(authentication, "authentication not null");
        if (authentication.getPrincipal() == null) {
            throw new IllegalArgumentException("authentication principal not null");
        }
        //1获取subject
        String subject = generateSubject(authentication);
        //2获取expiresIn
        Date nowTime = new Date();
        Date expiration = new Date(nowTime.getTime() + expirationIn);
        //3生成tokenValue
        String tokenValue;
        try {
            tokenValue = Jwts.builder().setSubject(subject)
                    .setIssuedAt(nowTime).setExpiration(expiration)
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compressWith(CompressionCodecs.GZIP).compact();
        } catch (Exception e) {
            throw new IllegalStateException("Generate tokenValue error", e);
        }
        //4保存authentication
        tokenStore.storeAuthentication(token_key + subject, authentication, expirationIn);
        return tokenValue;
    }

    private String generateSubject(Authentication authentication) {
        return authentication.getPrincipal() + REGEX + authentication.getClass().getName();
    }

    private Class<? extends Authentication> extractSubjectAuthClass(String subject) throws ClassNotFoundException {
        return (Class<? extends Authentication>) Class.forName(subject.split(REGEX)[1]);
    }

}

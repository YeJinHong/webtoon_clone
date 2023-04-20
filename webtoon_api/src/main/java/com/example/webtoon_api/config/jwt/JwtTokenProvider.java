package com.example.webtoon_api.config.jwt;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider implements InitializingBean {

    // access token header
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String REFRESH_HEADER = "Refresh";
    private static final String AUTHORITIES_KEY = "auth";
    private static final String BEARER_TYPE = "Bearer";
    private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 3;
    private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7 * 4;  // 만료시간 한달

    private Key key;

//    private final CustomUserDetailsService customUserDetailsService;


    @Override
    public void afterPropertiesSet() throws Exception {
        // TODO: @Value 적용하는 법 알기
//        @Value("${property.jwt.secretkey}")
        String secretKey = "this is secret key toooooooooooooooooooooooooooooooooooo looooooooooooooooooooooooooooooooooooong";
        String encodeKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
}

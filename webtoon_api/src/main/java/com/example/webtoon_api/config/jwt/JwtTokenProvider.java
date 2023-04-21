package com.example.webtoon_api.config.jwt;

import com.example.webtoon_api.api.common.TokenDTO;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.util.Base64;
import java.util.Date;

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
        key = Keys.hmacShaKeyFor(encodeKey.getBytes());
    }

    /**
     * [JWT 토큰 생성]
     * param : Authentication authentication
     * return : TokenDto
     * */
    public TokenDTO generateTokeDTO(String userId){
        long now = (new Date()).getTime();

        // 액세스 토큰 생성
        Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);
        String accessToken = Jwts.builder()
                .setSubject(userId)                         // payload "sub": "name"
                .setExpiration(accessTokenExpiresIn)        // payload "exp": 1516239022 (예시)
                .signWith(key, SignatureAlgorithm.HS512)    // header "alg": "HS512"
                .compact();

        // 리프레시 토큰 생성
        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now + REFRESH_TOKEN_EXPIRE_TIME))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

        // TokenDTO 생성하여 return
        return TokenDTO.builder()
                .AuthorizationHeader(AUTHORIZATION_HEADER)
                .RefreshHeader(REFRESH_HEADER)
                .grantType(BEARER_TYPE)
                .accessToken(accessToken)
                .accessTokenExpiresIn(accessTokenExpiresIn.getTime())
                .refreshToken(refreshToken)
                .build();
    }


    /**
     * [토큰 복호화]
     * param : String accessToken
     * return : Claims
     * */
    private Claims parseClaims(String accessToken){
        try{
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
        } catch (ExpiredJwtException e){
            return e.getClaims();
        }
    }

    /**
     * [토큰 검증]
     * param : String token
     * return : boolean
     * */
    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
        // JWT가 올바르게 구성되지 않았을 때
        log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }


    /**
     * [토큰 인증 및 사용자 정보 가져오기]
     * param : String accessToken
     * return : Authentication
     * */
//    public Authentication getAuthentication(String accessToken) {
//        // 토큰 복호화
//        Claims claims = parseClaims(accessToken);
//
//    }
}

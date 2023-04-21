package com.example.webtoon_api.api.common;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenDTO {
    private String AuthorizationHeader;
    private String RefreshHeader;
    private String grantType;
    private String accessToken;
    private long accessTokenExpiresIn;
    private String refreshToken;
}
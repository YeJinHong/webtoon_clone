package com.example.webtoon_api.api.auth.service.impl;

import com.example.webtoon_api.api.auth.presentation.dto.KakaoTokenDTO;

public interface OAuthService {
	public KakaoTokenDTO getAccessToken(String code);
}

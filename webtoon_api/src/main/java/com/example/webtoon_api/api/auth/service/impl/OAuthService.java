package com.example.webtoon_api.api.auth.service.impl;

import com.example.webtoon_api.api.auth.presentation.dto.KakaoTokenDTO;
import com.example.webtoon_api.api.auth.presentation.dto.LoginUserInfoDTO;

public interface OAuthService {
	public KakaoTokenDTO getAccessToken(String code);

	LoginUserInfoDTO saveUserOrLogin(String accessToken);
}

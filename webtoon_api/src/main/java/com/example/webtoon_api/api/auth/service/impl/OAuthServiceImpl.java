package com.example.webtoon_api.api.auth.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.example.webtoon_api.api.auth.presentation.dto.KakaoTokenDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OAuthServiceImpl implements OAuthService {

	@Value("${oauth2.registration.kakao.client-id}")
	private String kakaoClientId;

	@Value("${oauth2.registration.kakao.redirect-uri}")
	private String kakaoRedirectUri;

	/**
	 * 인가코드로 요청하여 카카오 AccessToken을 발급 받는 기능
	 * @param code
	 * @return KakaoTokenDto
	 * */
	@Override
	public KakaoTokenDTO getAccessToken(String code) {
		RestTemplate restTemplate = new RestTemplate();

		// 1. Header 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

		// 2. 카카오 Access token을 발급받기 위해 카카오 API key 및 Redirect Uri 입력
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", kakaoClientId);
		params.add("redirect_uri", kakaoRedirectUri); //REDIRECT URI
		params.add("code", code);

		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

		// 3. 카카오 Access token 발급 받기
		ResponseEntity<String> accessTokenResponse = restTemplate.exchange(
			"https://kauth.kakao.com/oauth/token",
			HttpMethod.POST,
			kakaoTokenRequest,
			String.class
		);

		// log.info("access : {}", accessTokenResponse);

		// 4. 발급받은 카카오 Access token 정보 중 필요한 정보만 KakaoTokenDTO에 저장
		ObjectMapper objectMapper = new ObjectMapper();
		KakaoTokenDTO kakaoTokenDTO = null;
		try {
			kakaoTokenDTO = objectMapper.readValue(accessTokenResponse.getBody(), KakaoTokenDTO.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return kakaoTokenDTO;
	}
}

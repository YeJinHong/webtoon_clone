//package com.example.webtoon_api.api.auth.presentation.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.webtoon_api.api.auth.presentation.dto.KakaoTokenDTO;
//import com.example.webtoon_api.api.auth.presentation.dto.LoginUserInfoDTO;
//import com.example.webtoon_api.api.auth.service.impl.OAuthServiceImpl;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Tag(name = "회원 인증")
//@Slf4j
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/oauth")
//public class OAuthController {
//
//	private final OAuthServiceImpl oauthService;
//	// private final RedisTemplate redisTemplate;
//	// private final TokenConverter tokenConverter;
//
//	@Operation(summary = " 카카오 소셜 로그인", description = "카카오로 소셜 로그인을 합니다.")
//	@GetMapping("/kakao/login")
//	public ResponseEntity<?> kakaoLogin(
//		@RequestParam(name = "code") String code
//	) {
//		// 1. 프론트에서 받은 kakao 인가 코드를 통해 kakao accessToken 발급
//		KakaoTokenDTO kakaoTokenDTO = oauthService.getAccessToken(code);
//		log.info("KakaoTokenDTO: {}", kakaoTokenDTO);
//
//		// 2. 발급받은 accessToken으로 카카오 회원 정보 확인 후 DB 저장 또는 로그인 (토큰 발급)
//		LoginUserInfoDTO loginUserInfoDTO = oauthService.saveUserOrLogin(kakaoTokenDTO.getAccessToken());
//
//		return null;
//	}
//}

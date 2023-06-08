package com.example.webtoon_api.api.webtoon.presentation.controller;

import com.example.webtoon_api.api.vo.WebtoonRegisterSO;
import com.example.webtoon_api.api.webtoon.presentation.dto.WebtoonRegisterRequestDTO;
import com.example.webtoon_api.api.webtoon.presentation.dto.WebtoonRegisterResponseDTO;
import com.example.webtoon_api.api.webtoon.presentation.validator.WebtoonValidator;
import com.example.webtoon_api.api.webtoon.service.impl.WebtoonService;
import com.example.webtoon_api.converter.WebtoonConverter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "웹툰 Controller")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/webtoons")
public class WebtoonController {

    private final WebtoonService webtoonService;
    private final WebtoonValidator webtoonValidator;
    private final WebtoonConverter webtoonConverter;

	 // 연재 대기 상태의 웹툰 등록
	 @PostMapping(
	     path = "",
		 consumes = {MediaType.APPLICATION_JSON_VALUE}
	 )
	 public ResponseEntity<WebtoonRegisterResponseDTO> registerWebtoon(
			 @RequestParam WebtoonRegisterRequestDTO webtoonRegisterRequestDTO
	 ){
		 // DTO NOT NULL 검증
		webtoonValidator.validateWebtoonRequestDTO(webtoonRegisterRequestDTO);

		// 웹툰 등록 정보 DB 저장
		 WebtoonRegisterSO webtoonRegisterSO = webtoonConverter.toWebtoonRegisterSO(webtoonRegisterRequestDTO);

	     return null;
	 }

	 // 웹툰의 연재 상태 변경

	//
	// 어떤 요일의 웹툰 리스트
	// @GetMapping(
	//     path = "/weekday/{weekday}"
	// )
	// public List<WebtoonResponseDTO> getWebtoonList(){
	//
	// }
	// 특정 웹툰 삭제
	// @DeleteMapping
	// public BaseResponse deleteWebtoon(@PathVariable String webtoonId){
	//
	// }
	// 웹툰 정보 수정 (요일, 작가, 상태)
}

package com.example.webtoon_api.api.webtoon.presentation.validator;


import com.example.webtoon_api.api.common.BaseValidator;
import com.example.webtoon_api.api.webtoon.presentation.dto.WebtoonRegisterRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class WebtoonValidator extends BaseValidator {
    public void validateWebtoonRequestDTO(WebtoonRegisterRequestDTO webtoonRegisterRequestDTO){
        checkStringType(webtoonRegisterRequestDTO.getTitle(), "웹툰 제목");
        checkStringType(webtoonRegisterRequestDTO.getAuthorId(), "작가 Id");
        checkStringType(webtoonRegisterRequestDTO.getDescription(), "웹툰 설명");
        checkIntegerListType(webtoonRegisterRequestDTO.getWeekdayList(), "웹툰 요일");
        checkStringType(webtoonRegisterRequestDTO.getAuthorId(), "작가 Id");
    }
}

package com.example.webtoon_api.converter;

import com.example.webtoon_api.api.vo.WebtoonRegisterSO;
import com.example.webtoon_api.api.webtoon.presentation.dto.WebtoonRegisterRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WebtoonConverter {
    WebtoonRegisterSO toWebtoonRegisterSO(WebtoonRegisterRequestDTO webtoonRegisterRequestDTO);
}

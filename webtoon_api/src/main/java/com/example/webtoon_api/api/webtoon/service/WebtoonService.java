package com.example.webtoon_api.api.webtoon.service;

import com.example.webtoon_api.api.vo.WebtoonRegisterSO;
import com.example.webtoon_api.api.webtoon.presentation.dto.WebtoonRegisterRequestDTO;
import com.example.webtoon_api.api.webtoon.presentation.dto.WebtoonRegisterResponseDTO;

public interface WebtoonService {
    WebtoonRegisterResponseDTO saveWebtoon(WebtoonRegisterSO webtoonRegisterSO);
}

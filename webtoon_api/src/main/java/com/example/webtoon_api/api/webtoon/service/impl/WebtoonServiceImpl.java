package com.example.webtoon_api.api.webtoon.service.impl;

import com.example.webtoon_api.api.vo.WebtoonRegisterSO;
import com.example.webtoon_api.api.webtoon.persistence.entity.WebtoonEntity;
import com.example.webtoon_api.api.webtoon.persistence.repository.WebtoonRepository;
import com.example.webtoon_api.api.webtoon.presentation.dto.WebtoonRegisterResponseDTO;
import com.example.webtoon_api.api.webtoon.service.WebtoonService;
import com.example.webtoon_api.converter.WebtoonConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebtoonServiceImpl implements WebtoonService {
  private final WebtoonRepository webtoonRepository;
  private final WebtoonConverter webtoonConverter;

  @Override
  public WebtoonRegisterResponseDTO saveWebtoon(WebtoonRegisterSO webtoonRegisterSO) {
    WebtoonEntity webtoonEntity = webtoonRepository.save(WebtoonEntity.builder()
            .title(webtoonRegisterSO.getTitle())
            .authorId(webtoonRegisterSO.getAuthorId())
            .description(webtoonRegisterSO.getDescription())
            .producerId(webtoonRegisterSO.getProducerId())
            .build()
    );
    WebtoonRegisterResponseDTO webtoonRegisterResponseDTO = webtoonConverter.toWebtoonRegisterResponseDTO(webtoonEntity);

    return webtoonRegisterResponseDTO;
  }
}

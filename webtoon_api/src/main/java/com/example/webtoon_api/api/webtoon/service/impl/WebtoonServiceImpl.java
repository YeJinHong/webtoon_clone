package com.example.webtoon_api.api.webtoon.service.impl;

import com.example.webtoon_api.api.webtoon.persistence.repository.WebtoonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WebtoonServiceImpl implements WebtoonService {
  private final WebtoonRepository webtoonRepository;

  
}

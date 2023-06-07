package com.example.webtoon_api.api.webtoon.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class WebtoonRegisterResponseDTO {
    @Schema(description = "웹툰 제목", defaultValue = "더블클릭")
    private String title;
    @Schema(description = "작가 이름", defaultValue = "김작가")
    private String authorName;
    @Schema(description = "웹툰 업로드일", defaultValue = "[0, 1]")
    private List<Integer> weekdayList;
    @Schema(description = "담당자 이름", defaultValue = "김프로")
    private String producerName;
    @Schema(description = "등록일", defaultValue = "2023-06-07")
    private String registerDate;
}

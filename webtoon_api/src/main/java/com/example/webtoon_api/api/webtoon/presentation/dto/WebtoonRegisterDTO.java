package com.example.webtoon_api.api.webtoon.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WebtoonRegisterDTO {
    @Schema(description = "웹툰 제목", defaultValue = "더블클릭")
    private String title;
    @Schema(description = "작가 Id", defaultValue = "authorId123")
    private String authorId;
    @Schema(description = "웹툰 설명", defaultValue = "")
    private String description;
    @Schema(description = "웹툰 업로드일", defaultValue = "0")
    private Integer weekday;

}

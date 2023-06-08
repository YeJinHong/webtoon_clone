package com.example.webtoon_api.api.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WebtoonRegisterSO {
    private String title;
    private String authorId;
    private String description;
    private List<Integer> weekdayList;
    private String producerId;
}

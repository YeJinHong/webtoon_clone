package com.example.webtoon_api.api.common;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseResponse<T> {
    private T data;//API 응답 결과 response
    private int status;//API 응답 결과 response
    private String message;//API 응답 결과 message

    @Builder
    public BaseResponse(T data, int status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }
}

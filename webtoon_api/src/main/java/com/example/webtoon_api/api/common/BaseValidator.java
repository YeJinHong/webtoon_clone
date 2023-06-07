package com.example.webtoon_api.api.common;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;


@Component
public class BaseValidator {
    public void checkLongType(Long value, String name) {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException(name + "은/는 필수 입력값이며 양수 값만 가능합니다.");
        }
    }

    public void checkIntType(int value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + "은/는 필수 입력값이며 양수 값만 가능합니다.");
        }
    }

    public void checkStringType(String value, String name) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(name + "은/는 필수 입력값입니다.");
        }
    }

    public void checkIntegerListType(List<Integer> list,String name){
        if(list == null || list.isEmpty())
            throw new IllegalArgumentException(name + "은/는 필수 입력값입니다.");
        if(list.stream().anyMatch(i -> i < 0 || 6 < i))
            throw new IllegalArgumentException(name + "의 값 중 범위(0-6)를 벗어난 값이 존재합니다.");

    }
}

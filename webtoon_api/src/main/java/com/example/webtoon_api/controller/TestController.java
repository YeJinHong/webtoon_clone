package com.example.webtoon_api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tests/")
@RequiredArgsConstructor
public class TestController {
    @GetMapping("hello")
    public String getHello(){
        return "hello";
    }
}

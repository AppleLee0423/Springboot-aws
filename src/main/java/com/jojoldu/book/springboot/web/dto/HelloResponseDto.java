package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
// final 필드가 포함된 생성자를 생성
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
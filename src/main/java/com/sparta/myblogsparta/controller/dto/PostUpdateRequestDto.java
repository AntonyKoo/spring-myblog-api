package com.sparta.myblogsparta.controller.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private String title;
    private String content;
    private String password;

    @Builder
    public PostUpdateRequestDto(String title, String content, String password) {
        this.title = title;
        this.content = content;
        this.password = password;
    }
}

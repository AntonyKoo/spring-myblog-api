package com.sparta.myblogsparta.controller.dto;

import com.sparta.myblogsparta.domain.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;
    private String password;

    public PostResponseDto(Post entity) {  // 일부 필드만 사용하므로, 생성자로 Entity를 받아 필드에 값을 넣음
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.password = entity.getPassword();
    }
}

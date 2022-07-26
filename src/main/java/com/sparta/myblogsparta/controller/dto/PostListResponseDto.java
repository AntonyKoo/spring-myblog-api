package com.sparta.myblogsparta.controller.dto;

import com.sparta.myblogsparta.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedAt;

    @Builder  // 빌더 클래스가 생성되어 setter 대신 각 필드값을 채워줌
    public PostListResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedAt = entity.getModifiedAt();

    }
}

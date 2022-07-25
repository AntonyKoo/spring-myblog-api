package com.sparta.myblogsparta.controller.dto;


import com.sparta.myblogsparta.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


// 요청&응답 용도 클래스, 뷰 레이어를 위한 클래스(변경이 잦다)
// Entity 클래스를 Request/Response 클래스로 사용하지 않기 위해 유사한 dto 생성
// Entity 클래스를 직접 자주 변경하는 것은 안정성에 좋지 x
@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
    @Builder
    public PostSaveRequestDto(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .password(password)
                .build();
    }
}

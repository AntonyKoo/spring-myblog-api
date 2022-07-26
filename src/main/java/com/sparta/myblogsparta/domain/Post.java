package com.sparta.myblogsparta.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter  // 클래스 내 모든 필드의 getter 메소 자동 추가
@NoArgsConstructor  // 기본 생성자 자동 추가
@Entity  // 테이블과 연결될 클래스임
public class Post {


    @Id  // 테이블의 pk 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // pk 생성 규칙
    private Long id;  // 고유 id, 자동 생성

    private String author;  // 게시글 작성자

    @Column(length = 500, nullable = false)  // 테이블의 컬럼, varchar size 변경 255 -> 500, not null
    private String title;  // 게시글 제목

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;  // 게시글 내용

    @Column(nullable = false)
    private String password;  // 게시글 비밀번호

    @Builder  // 생성자와 같은 역할, 필드에 정확한 값을 채울 수 있음
    public Post(String author, String title, String content, String password) {  // 생성자를 통한 인스턴스 초기화
        this.author = author;
        this.title = title;
        this.content = content;
        this.password = password;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}

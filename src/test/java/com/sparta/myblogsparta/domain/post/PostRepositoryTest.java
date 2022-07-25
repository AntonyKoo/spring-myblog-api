package com.sparta.myblogsparta.domain.post;

import com.sparta.myblogsparta.domain.PostRepository;
import com.sparta.myblogsparta.domain.Post;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After("")
    public void cleanup() {
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        String title = "테스트 글제목";
        String content = "테스트 글내용";
        String author = "테스트 작성자";
        String password = "테스트 비번";

        postRepository.save(Post.builder()  // 테이블에 insert(if id is null)/update(if id is not null) 쿼리를 실행
                .title(title)
                .content(content)
                .author(author)
                .password(password)
                .build());

        List<Post> postsList = postRepository.findAll();  // 모든 데이터 조회

        Post posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getAuthor()).isEqualTo(author);
        assertThat(posts.getPassword()).isEqualTo(password);

    }

}

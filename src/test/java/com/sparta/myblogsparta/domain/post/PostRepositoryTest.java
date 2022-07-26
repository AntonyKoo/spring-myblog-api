package com.sparta.myblogsparta.domain.post;

import com.sparta.myblogsparta.domain.PostRepository;
import com.sparta.myblogsparta.domain.Post;
import org.aspectj.lang.annotation.After;
import org.junit.Test; // org.junit.jupyter.api.Test로 import 되었다가 initializationError 떠서 바꿈
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
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

    @Test
    public void TimestampedEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.of(2022, 7, 26, 0, 0, 0);
        postRepository.save(Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .password("password")
                .build());

        // when
        List<Post> postList = postRepository.findAll();

        // then
        Post post = postList.get(0);

        System.out.println(">>>>>>>>>> createDate=" + post.getCreatedAt() + ", modifiedDate=" + post.getModifiedAt());

        assertThat(post.getCreatedAt()).isAfter(now);
        assertThat(post.getModifiedAt()).isAfter(now);
    }

}

package com.sparta.myblogsparta.service.post;


import com.sparta.myblogsparta.controller.dto.PostResponseDto;
import com.sparta.myblogsparta.controller.dto.PostSaveRequestDto;
import com.sparta.myblogsparta.controller.dto.PostUpdateRequestDto;
import com.sparta.myblogsparta.domain.Post;
import com.sparta.myblogsparta.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service  // 스프링님 이거슨 서비스에요.
public class PostService {
    private final PostRepository postRepository;  
    // SQL이 필요하기 때문에 SQL인터페이스 역할을 하는 repo 선언
    // 생성은 스프링님이 알아서 해주심

    // 등록(저장)
    @Transactional  // query가 일어나야 함을 스프링에게 알려줌
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    // 수정
    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        if (requestDto.getPassword().isEqualTo(postRepository.findById(id).getPassword())) {


        }
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id)
        );
        post.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    // 조회
    public PostResponseDto findById(Long id) {
        Post entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)
        );
        return  new PostResponseDto(entity);
    }

}

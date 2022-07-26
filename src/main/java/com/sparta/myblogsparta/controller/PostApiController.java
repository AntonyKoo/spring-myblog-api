package com.sparta.myblogsparta.controller;

import com.sparta.myblogsparta.controller.dto.PostResponseDto;
import com.sparta.myblogsparta.controller.dto.PostSaveRequestDto;
import com.sparta.myblogsparta.controller.dto.PostUpdateRequestDto;
import com.sparta.myblogsparta.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor  // final 선언된 모든 필드를 인자로 하는 생성자를 생성해줌, 생성자 구현 no 필요
@RestController  // json 형식으로
public class PostApiController {  // request data를 받는 api 구현 @controller

    private final PostService postService;

    @PostMapping("/api/post")  // 글 작성
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }
    // @RequestBody를 반드시 포함해야 요청 데이터를 제대로 받을 수 있긔

    @PutMapping("/api/post/{id}")  // 글 수정
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) { 
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/post/{id}")  // id 값을 통한 개별 글 조회
    public PostResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }
}

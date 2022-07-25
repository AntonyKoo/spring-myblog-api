package com.sparta.myblogsparta.controller;

import com.sparta.myblogsparta.controller.dto.PostResponseDto;
import com.sparta.myblogsparta.controller.dto.PostSaveRequestDto;
import com.sparta.myblogsparta.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {  // api 구현 controller

    private final PostService postService;

    @PostMapping("/api/post")  // 글 작성
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }

    @PutMapping("/api/post/{id}")  // 글 수정
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/post/{id}")  // 글 조회
    public PostResponseDto findById (@PathVariable Long id) {
        return postService.findById(id);
    }
}

package com.dndhackathon.healthy_honey_tving.domain.post.controller;

import com.dndhackathon.healthy_honey_tving.domain.post.dto.AddPostRequestDto;
import com.dndhackathon.healthy_honey_tving.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController("/api/v1/post")
public class PostController {
    private final PostService postService;

    @PutMapping("/post")
    public ResponseEntity<String> post(AddPostRequestDto requestDto) {
        postService.addPost(requestDto);
        return ResponseEntity.ok().build();
    }


}
